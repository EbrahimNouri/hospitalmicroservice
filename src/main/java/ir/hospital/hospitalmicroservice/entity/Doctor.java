package ir.hospital.hospitalmicroservice.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import lombok.*;

import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@ToString
public class Doctor extends Person {

    private String employeeNumber;
    private SpecialtyType specialtyType;

    @ManyToOne
    private Clinic clinic;

    @OneToMany(mappedBy = "doctor")
    @ToString.Exclude
    private Set<Queuing> queuings;

}
