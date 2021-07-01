package test.task.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import test.task.model.Document;
import test.task.repository.DocumentRepository;

import java.util.List;

@Service("appService")
public class AppService implements IAppService {

    private final DocumentRepository documentRepository;

    @Autowired
    public AppService(DocumentRepository documentRepository) {
        this.documentRepository = documentRepository;
    }


    @Override
    public void save(List<Document> documentList) {
        documentList.forEach(documentRepository::save);
    }

    @Override
    public void save(Document document) {
        documentRepository.save(document);
    }
}
