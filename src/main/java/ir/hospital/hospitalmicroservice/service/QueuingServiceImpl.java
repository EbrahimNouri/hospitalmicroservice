package ir.hospital.hospitalmicroservice.service;

import ir.hospital.hospitalmicroservice.entity.Queuing;
import ir.hospital.hospitalmicroservice.repository.QueuingRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
@AllArgsConstructor
public class QueuingServiceImpl implements QueuingService {

    private final QueuingRepository repository;

    @Override
    public List<Queuing> findAllByLocalDateAfterNow() {
        return repository.findAllByLocalDateAfterNow(LocalDate.now());
    }

    @Override
    public List<Queuing> findByPatientId(Long id){
        return repository.findQueuingsByPatientId(id);
    }
}
