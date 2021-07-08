package test.task.service;

import test.task.model.DocumentPOJO;
import test.task.model.ReportProjection;

import java.util.List;
import java.util.Map;

public interface AppService {
    void save(List<DocumentPOJO> list);

    void save(DocumentPOJO documentPOJO);

    Map<String, Object> getStatistics();

    ReportProjection getParticipantInfo(Long id);

    List<ReportProjection> getAllParticipantInfo();
}
