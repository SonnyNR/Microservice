package sia.domain;

import lombok.Data;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

import javax.persistence.Entity;
import java.util.Arrays;
import java.util.Collection;

@Data
@Entity
public class Professor extends User {

    private String career;
    private int    yearsOfExperience;

    public Professor() {

    }

    public Professor(String name, String phone, String address, String career, int yearsOfExperience,
                     String email, String password) {
        super(name, phone, address, email, password);
        this.career = career;
        this.yearsOfExperience = yearsOfExperience;

    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return Arrays.asList(new SimpleGrantedAuthority("ROLE_PROFESSOR"));
    }

}
