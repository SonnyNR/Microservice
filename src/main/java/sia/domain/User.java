package sia.domain;

import lombok.Data;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Arrays;
import java.util.Collection;
import java.util.Date;

@Data
@Entity
public class User implements UserDetails
{
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Id
    private Long id;

    private Role role;

    private String name;
    private String phone;
    private String address;
    private String nationality;
    private Sex    sex;
    private Date   dateOfBirth;
    private int    identificationNumber;

    private String email;
    private String password;

    public User() {

    }
    public User(Role role, String name, String phone, String address, String nationality,
                Sex sex, Date dateOfBirth, int identificationNumber, String email, String password) {

        this.role                 = role;
        this.name                 = name;
        this.phone                = phone;
        this.address              = address;
        this.nationality          = nationality;
        this.sex                  = sex;
        this.dateOfBirth          = dateOfBirth;
        this.identificationNumber = identificationNumber;
        this.email                = email;
        this.password             = password;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        if (role.equals(Role.ESTUDIANTE))
            return Arrays.asList(new SimpleGrantedAuthority("ROLE_STUDENT"));
        else
            return Arrays.asList(new SimpleGrantedAuthority("ROLE_PROFESSOR"));
    }

    @Override
    public String getUsername() {
        return email;
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


    public enum Role {
        ESTUDIANTE,
        PROFESOR,
    }


    public enum Sex {
        HOMBRE,
        MUJER,
    }

}