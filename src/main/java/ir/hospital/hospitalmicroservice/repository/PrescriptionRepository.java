package ir.hospital.hospitalmicroservice.repository;

import ir.hospital.hospitalmicroservice.entity.Prescription;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PrescriptionRepository extends JpaRepository<Prescription, Long> {

    List<Prescription> findByPatientNationalCode(String nationalCode);
}
