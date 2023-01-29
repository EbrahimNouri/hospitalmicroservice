package ir.hospital.hospitalmicroservice.dto;


import ir.hospital.hospitalmicroservice.entity.Doctor;
import ir.hospital.hospitalmicroservice.entity.SpecialtyType;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter
public class DoctorDto {
    private Long id;
    private String firstname;
    private String lastname;
    private SpecialtyType specialtyType;

    public static DoctorDto doctorToDoctorDto(Doctor doctor) {
        return DoctorDto.builder()
                .id(doctor.getId())
                .firstname(doctor.getFirstname())
                .lastname(doctor.getLastname())
                .specialtyType(doctor.getSpecialtyType())
                .build();
    }
}
