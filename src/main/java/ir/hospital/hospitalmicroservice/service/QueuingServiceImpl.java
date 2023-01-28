package ir.hospital.hospitalmicroservice.service;

import ir.hospital.hospitalmicroservice.entity.Queuing;
import ir.hospital.hospitalmicroservice.entity.QueuingCheck;
import ir.hospital.hospitalmicroservice.exception.QueuingException;
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
    public List<Queuing> findByPatientId(Long id) {
        return repository.findQueuingsByPatientId(id);
    }

    @Override
    public void addQueuing(Queuing queuing) {
        Queuing byId = repository.findById(queuing.getId()).orElse(null);

        if (byId == null) {
            queuing.setQueuingCheck(QueuingCheck.RESERVED);
        }

        assert byId != null;
        if (byId.getQueuingCheck().equals(QueuingCheck.RESERVED))
            throw new QueuingException("Could not add queuing to repository " + queuing.getId());

        if (byId.getQueuingCheck() == QueuingCheck.EMPTY) {
            queuing.setQueuingCheck(QueuingCheck.RESERVED);
        }

        if (byId.getLocalDate().isBefore(LocalDate.now())) {
            throw new QueuingException("this time is past");
        }

        repository.save(queuing);
    }
}
