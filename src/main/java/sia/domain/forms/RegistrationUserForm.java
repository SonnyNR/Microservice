package sia.domain.forms;

import lombok.Data;
import org.springframework.security.crypto.password.PasswordEncoder;
import sia.domain.User;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

@Data
public class RegistrationUserForm {

    private User.Role role;

    private String   name;
    private String   phone;
    private String   address;
    private String   nationality;
    private User.Sex sex;
    private Date dateOfBirth;
    private int      identificationNumber;

    private String email;
    private String password;

    public User toUser(PasswordEncoder encoder) {

        User user = null;

            user = new User
                    (getRole(), getName(), getPhone(), getAddress(), getNationality(), getSex(),
                            getDateOfBirth(), getIdentificationNumber(), getEmail(), encoder.encode(getPassword()));
        return user;
    }

}
