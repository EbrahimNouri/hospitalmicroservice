package ir.hospital.hospitalmicroservice.dto;

import ir.hospital.hospitalmicroservice.entity.*;
import lombok.*;

import java.time.LocalDate;


@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter
public class QueuingDto {

    private LocalDate localDate;

    private LocalDateType localDateType;

    private QueuingCheck queuingCheck;

    private Doctor doctor;

    public static Queuing queuingDtoToQueuing(QueuingDto queuingDto, Patient patient) {
        return Queuing.builder()
                .localDate(queuingDto.getLocalDate())
                .localDateType(queuingDto.getLocalDateType())
                .queuingCheck(queuingDto.getQueuingCheck())
                .doctor(queuingDto.getDoctor())
                .build();
    }

    public static QueuingDto queuingToQueuingDto(Queuing queuing) {
        return QueuingDto.builder()
                .localDate(queuing.getLocalDate())
                .localDateType(queuing.getLocalDateType())
                .queuingCheck(queuing.getQueuingCheck())
                .doctor(queuing.getDoctor())
                .build();
    }
}
