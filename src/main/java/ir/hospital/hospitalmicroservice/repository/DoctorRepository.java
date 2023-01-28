package ir.hospital.hospitalmicroservice.repository;

import ir.hospital.hospitalmicroservice.entity.Doctor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface DoctorRepository extends JpaRepository<Doctor, Long> {

    Optional<Doctor> findByNationalCode(String nationalCode);

    boolean existsByEmployeeNumber(String employeeNumber);

    @Query("select d from Doctor d where d.clinic.id = ?1")
    List<Doctor> fetchByClinic(Long clinicId);
}
