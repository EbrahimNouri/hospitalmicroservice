package ir.hospital.hospitalmicroservice.dto;

import ir.hospital.hospitalmicroservice.entity.Patient;
import ir.hospital.hospitalmicroservice.entity.Prescription;
import ir.hospital.hospitalmicroservice.entity.Queuing;
import lombok.*;

import java.util.Set;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter
public class PatientDto {
    private String firstname;

    private String lastname;

    private String nationalCode;

    private String phoneNumber;

    private String address;

    private Set<Queuing> queuings;

    private Set<Prescription> prescriptions;

    public static PatientDto patientToPatientDto(Patient patient) {
        return PatientDto.builder()
                .firstname(patient.getFirstname())
                .lastname(patient.getLastname())
                .nationalCode(patient.getNationalCode())
                .phoneNumber(patient.getPhoneNumber())
                .address(patient.getAddress())
                .prescriptions(patient.getPrescriptions())
                .queuings(patient.getQueuings())
                .build();
    }

    public static Patient patientDtoToPatient(PatientDto patientDto) {
        return Patient.builder()
                .firstname(patientDto.getFirstname())
                .lastname(patientDto.getLastname())
                .nationalCode(patientDto.getNationalCode())
                .phoneNumber(patientDto.getPhoneNumber())
                .address(patientDto.getAddress())
                .prescriptions(patientDto.getPrescriptions())
                .queuings(patientDto.getQueuings())
                .build();
    }
}
