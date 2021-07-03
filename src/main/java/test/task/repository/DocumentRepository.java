package test.task.repository;

import org.springframework.data.domain.Example;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import test.task.model.Document;

import java.util.List;

@Repository
public interface DocumentRepository extends JpaRepository<Document, Integer> {
    boolean existsByDocGUIDAndDocNum(String docGUID, Long docNum);
}
