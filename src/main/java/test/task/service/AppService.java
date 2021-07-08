package test.task.service;

import test.task.model.DocumentPOJO;

import java.util.List;
import java.util.Map;

public interface AppService {
    void save(List<DocumentPOJO> list);

    void save(DocumentPOJO documentPOJO);

    Map<String, Number> getStatistics();
}
