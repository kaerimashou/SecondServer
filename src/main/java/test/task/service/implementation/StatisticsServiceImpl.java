package test.task.service.implementation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import test.task.repository.DocumentRepository;
import test.task.service.StatisticsService;

@Service("statisticsService")
public class StatisticsServiceImpl implements StatisticsService {
    private final DocumentRepository documentRepository;

    private Double docAmount;
    private Double avgSum;

    @Autowired
    public StatisticsServiceImpl(DocumentRepository documentRepository) {
        this.documentRepository = documentRepository;
    }

    @Override
    public Double getDocAmount() {
        return docAmount;
    }

    @Override
    public Double getAvgSum() {
        return avgSum;
    }

    @Override
    public void updateStatistics() {
        docAmount = documentRepository.countAll();
        avgSum = documentRepository.getAvgSum();
    }
}
