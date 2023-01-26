package ir.hospital.hospitalmicroservice.entity;

import jakarta.persistence.Column;
import jakarta.persistence.MappedSuperclass;

import lombok.*;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@MappedSuperclass
@ToString
public abstract class Person  extends BaseEntity {
    private String firstname;

    private String lastname;

    @Column(unique = true, nullable = false)
    private String nationalCode;

    @Column(nullable = false)
    private String password;

    private String phoneNumber;

    private String address;

}
