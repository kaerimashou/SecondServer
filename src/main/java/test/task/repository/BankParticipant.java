package test.task.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import test.task.model.BankInfo;
import test.task.model.Document;

@Repository
public interface BankParticipant extends JpaRepository<BankInfo, Integer> {
}
