package ir.hospital.hospitalmicroservice.service;

import ir.hospital.hospitalmicroservice.entity.Patient;

public interface PrescriptionService {
    Patient findByNationalCode(String nationalCode);
}
