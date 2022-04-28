package co.ke.willsprojects.daraja.Models.MpesaConfirmations;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MpesaConfirmationRepository extends JpaRepository<MpesaConfirmation, Long> {
}
