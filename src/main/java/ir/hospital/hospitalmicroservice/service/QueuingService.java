package ir.hospital.hospitalmicroservice.service;

import ir.hospital.hospitalmicroservice.entity.Queuing;

import java.util.List;

public interface QueuingService {
    List<Queuing> findAllByLocalDateAfterNow();

    List<Queuing> findByPatientId(Long id);
}
