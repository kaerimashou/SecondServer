package test.task.service.implementation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import test.task.model.*;
import test.task.repository.BankRepository;
import test.task.repository.DocumentRepository;
import test.task.repository.ParticipantRepository;
import test.task.service.AppService;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service("appService")
public class AppServiceImpl implements AppService {

    private final DocumentRepository documentRepository;
    private final BankRepository bankRepository;
    private final ParticipantRepository participantRepository;

    private final StatisticsServiceImpl statisticsService;

    @Autowired
    public AppServiceImpl(DocumentRepository documentRepository, BankRepository bankRepository, ParticipantRepository participantRepository, StatisticsServiceImpl statisticsService) {
        this.documentRepository = documentRepository;
        this.bankRepository = bankRepository;
        this.participantRepository = participantRepository;
        this.statisticsService = statisticsService;
    }

    @Override
    public void save(List<DocumentPOJO> documentList) {
        documentList.forEach(this::save);
        statisticsService.updateStatistics();
    }

    @Override
    public void save(DocumentPOJO documentPOJO) {
        if (!documentRepository.existsByDocGUIDAndDocNum(documentPOJO.getDocGUID(), documentPOJO.getDocNum())) {
            Document document = new Document();
            document.setDocGUID(documentPOJO.getDocGUID());
            document.setDocDate(documentPOJO.getDocDate());
            document.setDocNum(documentPOJO.getDocNum());
            document.setOperType(documentPOJO.getOperType());
            document.setAmountOut(documentPOJO.getAmountOut());
            document.setPurpose(documentPOJO.getPurpose());

            saveBank(documentPOJO.getBankPayerInfo(), document);
            saveBank(documentPOJO.getBankReceiverInfo(), document);

            saveParticipant(documentPOJO.getReceiverInfo(), document);
            saveParticipant(document.getPayerInfo(), document);
            documentRepository.save(document);
        }
    }

    private void saveParticipant(ParticipantInfo participant, Document document) {
        //setting receiver and payer info
        if (participantRepository.countAllByInnAndKpp(participant.getInn(), participant.getKpp()) >= 1L) {
            document.setReceiverInfo(participantRepository.findTopParticipantInfoByInnAndKpp(participant.getInn(), participant.getKpp()));
        } else {
            if (participantRepository.countAllByName(participant.getName()) >= 1L) {
                document.setReceiverInfo(participantRepository.findTopParticipantInfoByName(participant.getName()));
            } else {
                document.setReceiverInfo(participant);
                participantRepository.save(participant);
            }
        }
    }

    private void saveBank(BankInfo bank, Document document) {
        //setting bank info of receiver or payer
        if (bankRepository.countAllByBic(bank.getBic()) >= 1L) {
            document.setBankReceiverInfo(bankRepository.findTopByBic(bank.getBic()));
        } else {
            document.setBankReceiverInfo(bank);
            bankRepository.save(bank);
        }
    }

    @Override
    public Map<String, Object> getStatistics() {
        Map<String, Object> stat = new HashMap<>();
        stat.put("count", statisticsService.getDocAmount());
        stat.put("avgSum", statisticsService.getAvgSum());
        return stat;
    }

    @Override
    public ReportProjection getParticipantInfo(Long id) {
        return statisticsService.getParticipantInfo(id);
    }

    @Override
    public List<ReportProjection> getAllParticipantInfo() {
        return statisticsService.getAllParticipantInfo();
    }


}
