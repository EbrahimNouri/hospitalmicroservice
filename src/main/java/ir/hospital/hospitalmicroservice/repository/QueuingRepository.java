package ir.hospital.hospitalmicroservice.repository;

import ir.hospital.hospitalmicroservice.entity.Queuing;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.time.LocalDate;
import java.util.List;


public interface QueuingRepository extends JpaRepository<Queuing, Long> {

    @Query("from Queuing q where q.localDate = :localDate")
    List<Queuing> findAllByLocalDateAfterNow(LocalDate localDate);

    List<Queuing> findQueuingsByPatientId(Long patientId);
}
