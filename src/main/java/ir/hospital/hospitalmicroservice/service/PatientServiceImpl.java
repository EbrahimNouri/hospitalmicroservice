package ir.hospital.hospitalmicroservice.service;

import ir.hospital.hospitalmicroservice.entity.Patient;
import ir.hospital.hospitalmicroservice.exception.Exist;
import ir.hospital.hospitalmicroservice.exception.NotFoundException;
import ir.hospital.hospitalmicroservice.repository.PatientRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class PatientServiceImpl implements PatientService {

    private final PatientRepository repository;

    @Override
    public Patient findByNationalCode(String nationalCode) {

        return repository.findByNationalCode(nationalCode)
                .orElseThrow(() -> new NotFoundException(
                        "doctor with this nationalCode {" + nationalCode + "} not found"));
    }

    @Override
    public void signup(Patient patient) {
        if (repository.existsById(patient.getId()))
            throw new Exist("patient with this id is already registered");
        if (repository.existsByNationalCode(patient.getNationalCode()))
            throw new Exist("patient with this nationalCode " + patient.getNationalCode() + " already exists");

        repository.save(patient);
    }

    @Override
    public Patient myDetail(Long id) {
        return findById(id);
    }

    @Override
    public Patient findById(Long id) {
        return repository.findById(id).orElseThrow
                (() -> new NotFoundException("patient with id " + id + " not found"));
    }
}
