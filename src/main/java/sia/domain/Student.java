package sia.domain;

import lombok.Data;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import javax.persistence.Entity;
import java.util.Arrays;
import java.util.Collection;

@Data
@Entity
public class Student extends User {

    private String degree;
    private int    academicSemester ;

    public Student() {
    }

    public Student(String name, String phone, String address, String degree, int academicSemester,
                   String email, String password) {

        super(name, phone, address, email, password);
        this.degree           = degree;
        this.academicSemester = academicSemester;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return Arrays.asList(new SimpleGrantedAuthority("ROLE_STUDENT"));
    }

}
