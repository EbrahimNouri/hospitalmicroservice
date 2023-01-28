package ir.hospital.hospitalmicroservice.entity;

import jakarta.persistence.Column;
import jakarta.persistence.MappedSuperclass;
import lombok.*;


@Getter
@Setter
@NoArgsConstructor
@MappedSuperclass
@ToString
public class Person extends BaseEntity {
    private String firstname;

    private String lastname;

    @Column(unique = true, nullable = false)
    private String nationalCode;

    @Column(nullable = false)
    private String password;

    private String phoneNumber;

    private String address;

    protected Person(Long id, String firstname, String lastname, String nationalCode, String password, String phoneNumber, String address) {
        super(id);
        this.firstname = firstname;
        this.lastname = lastname;
        this.nationalCode = nationalCode;
        this.password = password;
        this.phoneNumber = phoneNumber;
        this.address = address;
    }
}
