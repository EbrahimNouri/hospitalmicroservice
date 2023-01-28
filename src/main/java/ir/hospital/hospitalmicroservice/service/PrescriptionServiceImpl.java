package ir.hospital.hospitalmicroservice.service;

import ir.hospital.hospitalmicroservice.entity.Patient;
import ir.hospital.hospitalmicroservice.exception.NotFoundException;
import ir.hospital.hospitalmicroservice.repository.PatientRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@AllArgsConstructor
@Service
public class PrescriptionServiceImpl implements PrescriptionService {

    private final PatientRepository repository;

    @Override
    public Patient findByNationalCode(String nationalCode) {
        return repository.findByNationalCode(nationalCode)
                .orElseThrow(() -> new NotFoundException("Patient by " + nationalCode + "national ccode not found"));
    }
}
