package ir.hospital.hospitalmicroservice.dto;


import ir.hospital.hospitalmicroservice.entity.Clinic;
import lombok.*;

import java.util.Set;
import java.util.stream.Collectors;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter
public class ClinicDto {
    private String name;

    private String address;

    private Set<DoctorDto> doctors;

    public static ClinicDto clinicToClinicDto(Clinic clinic){
        return ClinicDto.builder()
                .address(clinic.getAddress())
                .name(clinic.getName())
                .doctors(clinic.getDoctors().stream()
                        .map(DoctorDto::doctorToDoctorDto).collect(Collectors.toSet()))
                .build();
    }

}
