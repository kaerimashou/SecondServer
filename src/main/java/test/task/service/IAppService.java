package test.task.service;

import test.task.model.Document;

import java.util.List;

public interface IAppService {
    void save(List<Document> document);
    void save(Document document);
}
