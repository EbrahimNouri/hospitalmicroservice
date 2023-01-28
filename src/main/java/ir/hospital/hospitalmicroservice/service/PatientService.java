package ir.hospital.hospitalmicroservice.service;

import ir.hospital.hospitalmicroservice.entity.Patient;

public interface PatientService {
    Patient findByNationalCode(String nationalCode);

    void signup(Patient patient);

    Patient myDetail(Long id);

    Patient findById(Long id);
}
