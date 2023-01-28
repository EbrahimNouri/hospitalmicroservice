package ir.hospital.hospitalmicroservice.service;

import ir.hospital.hospitalmicroservice.entity.Doctor;


public interface DoctorService {
    Doctor findByNationalCode(String nationalCode);

    void signup(Doctor doctor);
}
