package ir.hospital.hospitalmicroservice.service;

import ir.hospital.hospitalmicroservice.entity.Doctor;

import java.util.List;


public interface DoctorService {
    Doctor findByNationalCode(String nationalCode);

    void signup(Doctor doctor);

    List<Doctor> fetchAllDoctorByClinicId(Long clinicId);
}
