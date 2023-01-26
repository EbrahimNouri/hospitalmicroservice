package ir.hospital.hospitalmicroservice.repository;

import ir.hospital.entity.Clinic;
import ir.hospital.repository.BaseRepository;
import org.hibernate.Session;

import java.util.List;
import java.util.Optional;

public interface ClinicRepository extends BaseRepository<Clinic> {

    Optional<List<Clinic>> findAllClinics(Session session);


}
