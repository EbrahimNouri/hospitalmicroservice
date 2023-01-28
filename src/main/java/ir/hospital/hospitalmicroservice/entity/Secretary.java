package ir.hospital.hospitalmicroservice.entity;

import jakarta.persistence.*;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@ToString
public class Secretary extends Person {

    @OneToOne(fetch = FetchType.EAGER)
    private Clinic clinic;

}
