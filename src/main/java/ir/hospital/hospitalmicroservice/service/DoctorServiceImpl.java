package ir.hospital.hospitalmicroservice.service;

import ir.hospital.hospitalmicroservice.entity.Doctor;
import ir.hospital.hospitalmicroservice.exception.ExistException;
import ir.hospital.hospitalmicroservice.exception.NotFoundException;
import ir.hospital.hospitalmicroservice.repository.DoctorRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class DoctorServiceImpl implements DoctorService {
    private final DoctorRepository repository;

    @Override
    public Doctor findByNationalCode(String nationalCode) {
        return repository.findByNationalCode(nationalCode)
                .orElseThrow(() -> new NotFoundException(
                        "doctor with this nationalCode {" + nationalCode + "} not found"));
    }

    @Override
    public void signup(Doctor doctor) {
        if (repository.existsById(doctor.getId()))
            throw new ExistException("doctor with this id " + doctor.getId() + " already exists");
        if (repository.existsByEmployeeNumber(doctor.getEmployeeNumber()))
            throw new ExistException("doctor with this employee number " + doctor.getEmployeeNumber() + " already exists");

        repository.save(doctor);
    }

    @Override
    public List<Doctor> fetchAllDoctorByClinicId(Long clinicId) {
        return repository.fetchByClinic(clinicId);
    }
}
