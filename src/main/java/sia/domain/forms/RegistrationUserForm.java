package sia.domain.forms;

import lombok.Data;
import org.springframework.security.crypto.password.PasswordEncoder;
import sia.domain.User;

@Data
public class RegistrationUserForm {

    private String name;
    private String document;
    private String email;
    private String password;
    private String phone;
    private String address;

    public User toUser(PasswordEncoder encoder)
    {
        User user =  new User
                (getName(), getPhone(), getAddress(), getEmail(), encoder.encode(getPassword()));

        return user;
    }

}
