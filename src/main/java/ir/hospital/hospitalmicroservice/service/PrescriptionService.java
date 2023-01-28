package ir.hospital.hospitalmicroservice.service;

import ir.hospital.hospitalmicroservice.entity.Prescription;

import java.util.List;

public interface PrescriptionService {
    List<Prescription> fetchAllByPatientCode(String nationalCode);
}
