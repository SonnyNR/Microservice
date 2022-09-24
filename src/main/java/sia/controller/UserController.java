package sia.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import sia.domain.User;
import sia.domain.forms.RegistrationUserForm;
import sia.service.UserService;
import java.text.ParseException;
import java.util.List;

@Controller
public class UserController {

    @Autowired
    private UserService userService;
    private PasswordEncoder passwordEncoder;

    private UserController(UserService userService, PasswordEncoder passwordEncoder) {
        this.userService     = userService;
        this.passwordEncoder = passwordEncoder;
    }

    @QueryMapping
    public List<User> findAll() {
        return userService.findAll();
    }

    @QueryMapping
    public User findOne(@Argument Long id) {
        return userService.findById(id);
    }

    @MutationMapping
    public User createUser(@Argument("input") RegistrationUserForm form) throws ParseException {

        return userService.save(form.toUser(passwordEncoder));
    }

    @MutationMapping
    public User updateUser(@Argument Long id, @Argument("input") RegistrationUserForm form) {

        return userService.update(id, form);
    }

}
