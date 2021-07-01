package test.task.service;

import test.task.model.Document;

import java.util.List;

public interface AppService {
    void save(List<Document> document);

    void save(Document document);
}
