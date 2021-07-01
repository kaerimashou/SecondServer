package test.task.service.implementation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import test.task.model.Document;
import test.task.repository.BankParticipant;
import test.task.repository.DocumentRepository;
import test.task.repository.ParticipantRepository;
import test.task.service.AppService;

import java.util.List;

@Service("appService")
public class AppServiceImpl implements AppService {

    private final DocumentRepository documentRepository;
    private final BankParticipant bankParticipant;
    private final ParticipantRepository participantRepository;

    @Autowired
    public AppServiceImpl(DocumentRepository documentRepository, BankParticipant bankParticipant, ParticipantRepository participantRepository) {
        this.documentRepository = documentRepository;
        this.bankParticipant = bankParticipant;
        this.participantRepository = participantRepository;
    }

    @Override
    public void save(List<Document> documentList) {
        documentList.forEach(this::save);
    }

    @Override
    public void save(Document document) {
        documentRepository.save(document);
    }
}
