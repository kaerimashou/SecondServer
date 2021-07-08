package test.task.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import test.task.model.Document;

import java.math.BigDecimal;

@Repository
public interface DocumentRepository extends JpaRepository<Document, Integer> {
    boolean existsByDocGUIDAndDocNum(String docGUID, Long docNum);

    @Query(value = "SELECT COUNT(*) FROM Document", nativeQuery = true)
    Long countAll();

    @Query(value = "SELECT AVG(AMOUNT_OUT) FROM Document", nativeQuery = true)
    BigDecimal getAvgSum();
}
