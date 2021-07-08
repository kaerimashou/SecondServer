package test.task.service;

import java.math.BigDecimal;

public interface StatisticsService {
    Long getDocAmount();

    BigDecimal getAvgSum();

    void updateStatistics();
}
