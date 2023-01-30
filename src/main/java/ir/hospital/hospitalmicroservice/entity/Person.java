package ir.hospital.hospitalmicroservice.entity;

import jakarta.persistence.Column;
import jakarta.persistence.MappedSuperclass;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.List;


@Getter
@Setter
@NoArgsConstructor
@MappedSuperclass
@ToString
public class Person extends BaseEntity implements UserDetails {
    private String firstname;

    private String lastname;

    @Column(unique = true, nullable = false)
    private String nationalCode;

    @Column(nullable = false)
    private String password;

    private String phoneNumber;

    private String address;

    private Role role;

    protected Person(Long id, String firstname, String lastname, String nationalCode, String password, String phoneNumber, String address) {
        super(id);
        this.firstname = firstname;
        this.lastname = lastname;
        this.nationalCode = nationalCode;
        this.password = password;
        this.phoneNumber = phoneNumber;
        this.address = address;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return List.of(new SimpleGrantedAuthority(getRole().name()));
    }

    @Override
    public String getUsername() {
        return nationalCode;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
