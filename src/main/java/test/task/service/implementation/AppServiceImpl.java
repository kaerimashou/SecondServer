package test.task.service.implementation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import test.task.model.Document;
import test.task.model.DocumentPOJO;
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

            //setting bankPayerInfo
            if (bankRepository.countAllByBic(documentPOJO.getBankPayerInfo().getBic()) >= 1L) {
                document.setBankPayerInfo(bankRepository.findTopByBic(documentPOJO.getBankPayerInfo().getBic()));
            } else {
                document.setBankPayerInfo(documentPOJO.getBankPayerInfo());
                bankRepository.save(documentPOJO.getBankPayerInfo());
            }

            //setting bankReceiverInfo
            if (bankRepository.countAllByBic(documentPOJO.getBankReceiverInfo().getBic()) >= 1L) {
                document.setBankReceiverInfo(bankRepository.findTopByBic(documentPOJO.getBankPayerInfo().getBic()));
            } else {
                document.setBankReceiverInfo(documentPOJO.getBankReceiverInfo());
                bankRepository.save(documentPOJO.getBankReceiverInfo());
            }

            //setting payerInfo
            if (participantRepository.countAllByInnAndKpp(documentPOJO.getPayerInfo().getInn(), documentPOJO.getPayerInfo().getKpp()) >= 1L) {
                document.setPayerInfo(participantRepository.findTopParticipantInfoByInnAndKpp(documentPOJO.getPayerInfo().getInn(), documentPOJO.getPayerInfo().getKpp()));
            } else {
                if (participantRepository.countAllByName(documentPOJO.getPayerInfo().getName()) >= 1L) {
                    document.setPayerInfo(participantRepository.findTopParticipantInfoByName(documentPOJO.getPayerInfo().getName()));
                } else {
                    document.setPayerInfo(documentPOJO.getPayerInfo());
                    participantRepository.save(documentPOJO.getPayerInfo());
                }
            }

            //setting receiverInfo
            if (participantRepository.countAllByInnAndKpp(documentPOJO.getReceiverInfo().getInn(), documentPOJO.getReceiverInfo().getKpp()) >= 1L) {
                document.setReceiverInfo(participantRepository.findTopParticipantInfoByInnAndKpp(documentPOJO.getReceiverInfo().getInn(), documentPOJO.getReceiverInfo().getKpp()));
            } else {
                if (participantRepository.countAllByName(documentPOJO.getReceiverInfo().getName()) >= 1L) {
                    document.setReceiverInfo(participantRepository.findTopParticipantInfoByName(documentPOJO.getReceiverInfo().getName()));
                } else {
                    document.setReceiverInfo(documentPOJO.getReceiverInfo());
                    participantRepository.save(documentPOJO.getReceiverInfo());
                }
            }
            documentRepository.save(document);
            statisticsService.updateStatistics();
        }
    }

    public Map<String, Double> getStatistics() {
        Map<String, Double> stat = new HashMap<>();
        stat.put("count", statisticsService.getDocAmount());
        stat.put("avgSum", statisticsService.getAvgSum());
        return stat;
    }
}
