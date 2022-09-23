package sia.domain.forms;

import lombok.Data;
import org.springframework.security.crypto.password.PasswordEncoder;
import sia.domain.Student;

@Data
public class RegistrationStudentForm extends RegistrationUserForm {

    private String degree;
    private int    academicSemester ;

    public Student toStudent(PasswordEncoder encoder)
    {
        Student student =  new Student
                (getName(), getPhone(), getAddress(),  getDegree(),
                        getAcademicSemester(), getEmail(), encoder.encode(getPassword()));

        return student;
    }

}

