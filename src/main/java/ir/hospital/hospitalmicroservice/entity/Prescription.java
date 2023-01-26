package ir.hospital.hospitalmicroservice.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@ToString
@Builder
public class Prescription  extends BaseEntity {

    @ManyToOne
    private Doctor doctor;

    @ManyToOne
    private Patient patient;

    private String disease;

    private String description;

    private LocalDate localDate;

}
