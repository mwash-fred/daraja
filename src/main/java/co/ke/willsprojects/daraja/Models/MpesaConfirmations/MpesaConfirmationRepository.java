package co.ke.willsprojects.daraja.Models.MpesaConfirmations;

import co.ke.willsprojects.daraja.Interface.PartTran;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface MpesaConfirmationRepository extends JpaRepository<MpesaConfirmation, Long> {
    MpesaConfirmation findByMpesaTransactionNo(String transactionNo);

    @Query(value = "select * from part_tran where tran_particulars regexp :code limit 1", nativeQuery = true)
    PartTran mpesaPart(@Param("code") String mpesaCode);
}
