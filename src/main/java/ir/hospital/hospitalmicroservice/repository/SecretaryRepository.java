package ir.hospital.hospitalmicroservice.repository;

import ir.hospital.hospitalmicroservice.entity.Doctor;
import ir.hospital.hospitalmicroservice.entity.Patient;
import ir.hospital.hospitalmicroservice.entity.Secretary;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface SecretaryRepository extends JpaRepository<Secretary, Long> {
    Optional<Secretary> findByNationalCode(String nationalCode);

    @Query("select sp from Secretary s join s.clinic sc join sc.patients sp where s = :secretary")
    List<Patient> findAllPatient(Secretary secretary);

    @Query("select sd from Secretary s join s.clinic sc join sc.doctors sd where s = :secretary")
    List<Doctor> showAllDoctors(Secretary secretary);

}
