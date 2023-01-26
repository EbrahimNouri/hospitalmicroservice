package ir.hospital.hospitalmicroservice.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;


@Getter
@Setter
@NoArgsConstructor
@Entity
@Builder
@ToString
@AllArgsConstructor
public class Queuing  extends BaseEntity{

    private LocalDate localDate;

    private LocalDateType localDateType;

    private QueuingCheck queuingCheck = QueuingCheck.EMPTY;

    @ManyToOne
    private Doctor doctor;

    @ManyToOne
    private Patient patient;


}
