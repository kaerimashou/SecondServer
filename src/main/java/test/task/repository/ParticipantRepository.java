package test.task.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import test.task.model.ParticipantInfo;

@Repository
public interface ParticipantRepository extends JpaRepository<ParticipantInfo, Integer> {
    long countAllByInnAndKpp(String inn, String kpp);
    long countAllByName(String name);
    ParticipantInfo findTopParticipantInfoByInnAndKpp(String inn, String kpp);
    ParticipantInfo findTopParticipantInfoByName(String name);
}
