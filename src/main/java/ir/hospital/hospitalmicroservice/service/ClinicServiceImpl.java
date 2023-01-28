package ir.hospital.hospitalmicroservice.service;

import ir.hospital.hospitalmicroservice.entity.Clinic;
import ir.hospital.hospitalmicroservice.repository.ClinicRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class ClinicServiceImpl  implements ClinicService{

    private final ClinicRepository repository;

    @Override
    public List<Clinic> fetchAll(){
        return repository.findAll();
    }
}
