package ir.hospital.hospitalmicroservice.service;

import ir.hospital.hospitalmicroservice.entity.Prescription;
import ir.hospital.hospitalmicroservice.repository.PrescriptionRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@AllArgsConstructor
@Service
public class PrescriptionServiceImpl implements PrescriptionService {

    private final PrescriptionRepository repository;

    @Override
    public List<Prescription> fetchAllByPatientCode(String nationalCode){
        return repository.findByPatientNationalCode(nationalCode);
    }
}
