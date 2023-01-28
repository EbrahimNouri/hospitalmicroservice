package ir.hospital.hospitalmicroservice.service;

import ir.hospital.hospitalmicroservice.entity.Doctor;
import ir.hospital.hospitalmicroservice.entity.Patient;
import ir.hospital.hospitalmicroservice.entity.Secretary;
import ir.hospital.hospitalmicroservice.exception.Exist;
import ir.hospital.hospitalmicroservice.exception.NotFoundException;
import ir.hospital.hospitalmicroservice.repository.SecretaryRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class SecretaryServiceImpl implements SecretaryService {

    private final SecretaryRepository repository;

    @Override
    public Secretary findByNationalCode(String nationalCode) {
        return repository.findByNationalCode(nationalCode)
                .orElseThrow(() -> new NotFoundException("No national code found"));
    }

    @Override
    public List<Patient> findAllPatient(Secretary secretary) {
        return repository.findAllPatient(secretary);
    }

    @Override
    public List<Doctor> showAllDoctors(Secretary secretary) {
        return repository.showAllDoctors(secretary);
    }

    @Override
    public void signup(Secretary secretary) {
        if (repository.existsById(secretary.getId()))
            throw new Exist("secretary with this id is already registered");
        if (repository.existsByNationalCode(secretary.getNationalCode()))
            throw new Exist("secretary with this national code is already registered");

        repository.save(secretary);
    }
}
