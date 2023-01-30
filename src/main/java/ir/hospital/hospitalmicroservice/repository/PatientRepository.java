package ir.hospital.hospitalmicroservice.repository;

import ir.hospital.hospitalmicroservice.entity.Patient;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface PatientRepository extends JpaRepository<Patient, Long> {
    Optional<Patient> findByNationalCode(String nationalCode);

    boolean existsByNationalCode(String nationalCode);
}
