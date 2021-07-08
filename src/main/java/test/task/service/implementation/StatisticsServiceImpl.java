package test.task.service.implementation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import test.task.repository.DocumentRepository;
import test.task.service.StatisticsService;

import java.math.BigDecimal;

@Service("statisticsService")
public class StatisticsServiceImpl implements StatisticsService {
    private final DocumentRepository documentRepository;

    private Long docAmount;
    private BigDecimal avgSum;

    @Autowired
    public StatisticsServiceImpl(DocumentRepository documentRepository) {
        this.documentRepository = documentRepository;
    }

    @Override
    public Long getDocAmount() {
        return docAmount;
    }

    @Override
    public BigDecimal getAvgSum() {
        return avgSum;
    }

    @Override
    public void updateStatistics() {
        docAmount = documentRepository.countAll();
        avgSum = documentRepository.getAvgSum();
    }
}
