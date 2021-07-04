package test.task.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import test.task.model.BankInfo;

@Repository
public interface BankRepository extends JpaRepository<BankInfo, Integer> {
    long countAllByBic(Long bic);

    BankInfo findTopByBic(Long bic);
}
