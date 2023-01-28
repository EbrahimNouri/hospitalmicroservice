package ir.hospital.hospitalmicroservice.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@ToString
public class Patient extends Person {

    @ManyToOne(fetch = FetchType.EAGER)
    private Clinic clinic;

    @OneToMany(mappedBy = "patient")
    @ToString.Exclude
    private Set<Queuing> queuings;

    @OneToMany(mappedBy = "patient", fetch = FetchType.EAGER)
    private Set<Prescription> prescriptions;

    @Builder
    public Patient(Long id, String firstname, String lastname, String nationalCode, String password, String phoneNumber, String address, Clinic clinic, Set<Queuing> queuings, Set<Prescription> prescriptions) {
        super(id, firstname, lastname, nationalCode, password, phoneNumber, address);
        this.clinic = clinic;
        this.queuings = queuings;
        this.prescriptions = prescriptions;
    }
}
