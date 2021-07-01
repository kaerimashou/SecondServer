package test.task.service.implementation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import test.task.model.Document;
import test.task.repository.DocumentRepository;
import test.task.service.AppService;

import java.util.List;

@Service("appService")
public class AppServiceImpl implements AppService {

    private final DocumentRepository documentRepository;

    @Autowired
    public AppServiceImpl(DocumentRepository documentRepository) {
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
