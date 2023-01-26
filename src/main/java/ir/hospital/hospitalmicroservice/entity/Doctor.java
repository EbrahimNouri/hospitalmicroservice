package ir.hospital.hospitalmicroservice.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@Entity
@ToString
public class Doctor extends Person{

    private String employeeNumber;
    private SpecialtyType  specialtyType;

    @ManyToOne
    private Clinic clinic;

    @OneToMany(mappedBy = "doctor")
    @ToString.Exclude
    private Set<Queuing> queuings;

    @Builder
    public Doctor(String firstname, String lastname, String nationalCode, String password, String phoneNumber, String address, String employeeNumber, SpecialtyType specialtyType, Clinic clinic, Set<Queuing> queuings) {
        super(firstname, lastname, nationalCode, password, phoneNumber, address);
        this.employeeNumber = employeeNumber;
        this.specialtyType = specialtyType;
        this.clinic = clinic;
        this.queuings = queuings;
    }
}
