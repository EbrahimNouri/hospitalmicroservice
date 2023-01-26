package ir.hospital.hospitalmicroservice.entity;

import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@Entity
@ToString
public class Secretary extends Person{

    @OneToOne(fetch = FetchType.EAGER)
    private Clinic clinic;

    @Builder
    public Secretary(String firstname, String lastname, String nationalCode, String password, String phoneNumber, String address, Clinic clinic) {
        super(firstname, lastname, nationalCode, password, phoneNumber, address);
        this.clinic = clinic;
    }
}
