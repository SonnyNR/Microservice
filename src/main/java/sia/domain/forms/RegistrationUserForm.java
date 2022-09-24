package sia.domain.forms;

import lombok.Data;
import org.springframework.security.crypto.password.PasswordEncoder;
import sia.domain.User;

import java.text.ParseException;
import java.text.SimpleDateFormat;

@Data
public class RegistrationUserForm {

    private String role;

    private String   name;
    private String   phone;
    private String   address;
    private String   nationality;
    private String   sex;
    private String   dateOfBirth;
    private int      identificationNumber;

    private String email;
    private String password;

    public User toUser(PasswordEncoder encoder) throws ParseException {

        User user =  new User
                (User.Role.valueOf(getRole()), getName(), getPhone(), getAddress(), getNationality(), User.Sex.valueOf(getSex()),
                        new SimpleDateFormat("dd/MM/yyyy").parse(getDateOfBirth()), getIdentificationNumber(), getEmail(), encoder.encode(getPassword()));

        return user;
    }

}
