package test.task.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import test.task.model.ParticipantInfo;

@Repository
public interface ParticipantRepository extends JpaRepository<ParticipantInfo, Integer> {
}
