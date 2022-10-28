package sia.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;
import sia.domain.User;
import sia.domain.forms.RegistrationUserForm;
import sia.service.UserService;
import javax.servlet.http.HttpSession;
import java.security.Principal;
import java.util.List;

@RestController
@CrossOrigin("*")
@RequestMapping("/register")
public class RegisterController {

    private UserService     userService;
    private PasswordEncoder passwordEncoder;

    @Autowired
    public RegisterController(UserService userService, PasswordEncoder passwordEncoder) {
        this.userService = userService;
        this.passwordEncoder = passwordEncoder;
    }

    @PostMapping(path = "/create", consumes = "application/json")
    @ResponseStatus(HttpStatus.CREATED)
    public User createStudent(@RequestBody RegistrationUserForm form) {
        return userService.save(form.toUser(passwordEncoder));
    }

    @GetMapping(path = "/user/{id}", produces = "application/json")
    public User getUser(@PathVariable("id") Long id) {
        return userService.findById(id);
    }

    @GetMapping(path = "/user/username/{username}", produces = "application/json")
    public User getUserByUsername(@PathVariable("username") String username) {
        return userService.findByEmail(username + "@unal.edu.co");
    }

    @GetMapping(path = "/users", produces = "application/json")
    public List<User> getUsers(HttpSession session, Principal principal) {
        return userService.findAll();
    }

    @PatchMapping(path="/update/{id}", consumes = "application/json")
    public User updateStudent(@PathVariable("id") Long id,
                              @RequestBody RegistrationUserForm form) {

        return userService.update(id, form);
    }

    @DeleteMapping(path = "/delete/{id}")
    public void deleteStudent(@PathVariable("id") Long id) {
        userService.delete(id);
    }

    @GetMapping(path = "/role/{id}")
    public String getRoleUser(@PathVariable("id") Long id) {
        return userService.findById(id).getRole().toString();
    }

    @GetMapping(path = "/user", produces = "application/json")
    public User getCurrentUser(Principal principal) {
        if (principal != null)
            return userService.findByEmail(principal.getName());
        else
            return null;
    }


}
