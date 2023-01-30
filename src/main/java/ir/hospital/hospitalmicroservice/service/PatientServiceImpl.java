package ir.hospital.hospitalmicroservice.service;

import ir.hospital.hospitalmicroservice.config.CustomPasswordEncoder;
import ir.hospital.hospitalmicroservice.entity.Patient;
import ir.hospital.hospitalmicroservice.exception.ExistException;
import ir.hospital.hospitalmicroservice.exception.NotFoundException;
import ir.hospital.hospitalmicroservice.repository.PatientRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class PatientServiceImpl implements PatientService {

    private final PatientRepository repository;
    private final CustomPasswordEncoder bc;

    @Override
    public Patient findByNationalCode(String nationalCode) {

        return repository.findByNationalCode(nationalCode)
                .orElseThrow(() -> new NotFoundException(
                        "doctor with this nationalCode {" + nationalCode + "} not found"));
    }

    @Override
    public void signup(Patient patient) {
        if (repository.existsById(patient.getId()))
            throw new ExistException("patient with this id is already registered");
        if (repository.existsByNationalCode(patient.getNationalCode()))
            throw new ExistException("patient with this nationalCode " + patient.getNationalCode() + " already exists");

        patient.setPassword(bc.bCryptPasswordEncoder().encode(patient.getPassword()));
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

    @Override
    public List<Patient> fetchAll() {
        return repository.findAll();
    }
}
