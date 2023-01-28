package ir.hospital.hospitalmicroservice.service;

import ir.hospital.hospitalmicroservice.entity.Clinic;

import java.util.List;

public interface ClinicService {
    List<Clinic> fetchAll();
}
