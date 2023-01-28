package ir.hospital.hospitalmicroservice.dto;

import ir.hospital.hospitalmicroservice.entity.Patient;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter
public class PatientRegisterDto {
    private String firstname;

    private String lastname;

    private String nationalCode;

    private String phoneNumber;

    private String address;

    public static PatientDto patientToPatientRegisterDto(Patient patient) {
        return PatientDto.builder()
                .firstname(patient.getFirstname())
                .lastname(patient.getLastname())
                .nationalCode(patient.getNationalCode())
                .phoneNumber(patient.getPhoneNumber())
                .address(patient.getAddress())
                .build();
    }

    public static Patient patientRegisterDtoToPatient(PatientRegisterDto patientRegisterDto) {
        return Patient.builder()
                .firstname(patientRegisterDto.getFirstname())
                .lastname(patientRegisterDto.getLastname())
                .nationalCode(patientRegisterDto.getNationalCode())
                .phoneNumber(patientRegisterDto.getPhoneNumber())
                .address(patientRegisterDto.getAddress())
                .build();
    }
}
