package test.task.service;

import test.task.model.DocumentPOJO;

import java.util.List;

public interface AppService {
    void save(List<DocumentPOJO> list);

    void save(DocumentPOJO documentPOJO);


}
