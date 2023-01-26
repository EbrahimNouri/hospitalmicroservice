package ir.hospital.hospitalmicroservice.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.Set;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity
@Builder
public class Clinic extends BaseEntity{

    private String name;

    private String address;

    @OneToMany(mappedBy = "clinic", fetch = FetchType.EAGER)
    private Set<Doctor> doctors;

    @OneToMany(mappedBy = "clinic", fetch = FetchType.EAGER)
    private Set<Patient> patients;

    @OneToOne
    private Secretary secretary;

}
