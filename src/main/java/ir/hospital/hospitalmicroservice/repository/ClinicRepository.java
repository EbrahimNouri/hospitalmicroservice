package ir.hospital.hospitalmicroservice.repository;

import ir.hospital.hospitalmicroservice.entity.Clinic;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ClinicRepository extends JpaRepository<Clinic, Long> {

    List<Clinic> findAll();
}
