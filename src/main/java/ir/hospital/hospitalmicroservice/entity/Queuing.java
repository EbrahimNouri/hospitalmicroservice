package ir.hospital.hospitalmicroservice.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;


@Getter
@Setter
@NoArgsConstructor
@Entity
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

    @Builder
    public Queuing(Long id, LocalDate localDate, LocalDateType localDateType, QueuingCheck queuingCheck, Doctor doctor, Patient patient) {
        super(id);
        this.localDate = localDate;
        this.localDateType = localDateType;
        this.queuingCheck = queuingCheck;
        this.doctor = doctor;
        this.patient = patient;
    }
}
