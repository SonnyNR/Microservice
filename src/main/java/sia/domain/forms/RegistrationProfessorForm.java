package sia.domain.forms;

import lombok.Data;
import org.springframework.security.crypto.password.PasswordEncoder;
import sia.domain.Professor;

@Data
public class RegistrationProfessorForm extends RegistrationUserForm {

    private String career;
    private int    yearsOfExperience;

    public Professor toProfessor(PasswordEncoder encoder)
    {
        Professor professor =  new Professor
                (getName(), getPhone(), getAddress(), getCareer(), getYearsOfExperience(),
                        getEmail(), encoder.encode(getPassword()));

        return professor;
    }

}
