package ir.hospital.hospitalmicroservice.service;

import ir.hospital.hospitalmicroservice.entity.Doctor;
import ir.hospital.hospitalmicroservice.entity.Patient;
import ir.hospital.hospitalmicroservice.entity.Secretary;

import java.util.List;

public interface SecretaryService {

    Secretary findByNationalCode(String nationalCode);

    List<Patient> findAllPatient(Secretary secretary);

    List<Doctor> showAllDoctors(Secretary secretary);

    void signup(Secretary secretary);
}
