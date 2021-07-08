package test.task.service;

import test.task.model.ReportProjection;

import java.math.BigDecimal;
import java.util.List;

public interface StatisticsService {
    Long getDocAmount();

    BigDecimal getAvgSum();

    void updateStatistics();

    ReportProjection getParticipantInfo(Long id);

    List<ReportProjection> getAllParticipantInfo();
}
