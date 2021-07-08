package test.task.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import test.task.model.Document;
import test.task.model.ReportProjection;

import java.math.BigDecimal;
import java.util.List;

@Repository
public interface DocumentRepository extends JpaRepository<Document, Integer> {
    boolean existsByDocGUIDAndDocNum(String docGUID, Long docNum);

    @Query(value = "SELECT COUNT(*) FROM Document", nativeQuery = true)
    Long countAll();

    @Query(value = "SELECT AVG(AMOUNT_OUT) FROM Document", nativeQuery = true)
    BigDecimal getAvgSum();

    @Query(value = "SELECT participant.name as name,CASE WHEN payer IS NULL then 0 ELSE payer END as countPayer,CASE WHEN receiver IS NULL then 0 ELSE receiver END as countReceiver \n" +
            "FROM document INNER JOIN participant ON payer_id=participant.id OR receiver_id=participant.id\n" +
            "LEFT OUTER JOIN (\n" +
            "    SELECT participant.name as payername,count(*) as payer\n" +
            "    FROM document INNER JOIN participant ON payer_id=participant.id\n" +
            "    GROUP BY participant.name\n" +
            "    ) as payercount ON payername=participant.name\n" +
            "LEFT OUTER JOIN(\n" +
            "    SELECT participant.name as receivername,count(*) as receiver\n" +
            "    FROM document INNER JOIN participant ON receiver_id=participant.id\n" +
            "    GROUP BY participant.name\n" +
            "    ) as receivercount ON receivername=participant.name\n" +
            "WHERE participant.id=?1\n" +
            "GROUP BY participant.name,countPayer,countReceiver",
            nativeQuery = true)
    ReportProjection getParticipantInfo(Long id);

    @Query(value = "SELECT participant.name as name,CASE WHEN payer IS NULL then 0 ELSE payer END as countPayer,CASE WHEN receiver IS NULL then 0 ELSE receiver END as countReceiver \n" +
            "FROM document INNER JOIN participant ON payer_id=participant.id OR receiver_id=participant.id\n" +
            "LEFT OUTER JOIN (\n" +
            "    SELECT participant.name as payername,count(*) as payer\n" +
            "    FROM document INNER JOIN participant ON payer_id=participant.id\n" +
            "    GROUP BY participant.name\n" +
            "    ) as payercount ON payername=participant.name\n" +
            "LEFT OUTER JOIN(\n" +
            "    SELECT participant.name as receivername,count(*) as receiver\n" +
            "    FROM document INNER JOIN participant ON receiver_id=participant.id\n" +
            "    GROUP BY participant.name\n" +
            "    ) as receivercount ON receivername=participant.name\n" +
            "GROUP BY participant.name,countPayer,countReceiver",
            nativeQuery = true)
    List<ReportProjection> getParticipantInfoAll();
}
