package sia.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sia.domain.User;
import sia.domain.forms.RegistrationUserForm;
import sia.repository.UserRepository;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Locale;

@Service
public class UserService
{
    private UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository)
    {
        this.userRepository = userRepository;
    }

    public List<User> findAll() {
        return userRepository.findAll();
    }

    public User findByEmail(String email)
    {
        return userRepository.findByEmail(email);
    }

    public User findById(Long id) {
        return userRepository.findUserById(id);
    }

    public User save(User user)
    {
        return userRepository.save(user);
    }

    public User update(Long id, RegistrationUserForm form) {

        User user = findById(id);

        if (form.getRole() != null)
            user.setRole(form.getRole());
        if (form.getName() != null)
            user.setName(form.getName());
        if (form.getPhone() != null)
            user.setPhone(form.getPhone());
        if (form.getAddress() != null)
            user.setAddress(form.getAddress());
        if (form.getNationality() != null)
            user.setNationality(form.getNationality());
        if (form.getSex() != null)
            user.setSex(form.getSex());
        if (form.getDateOfBirth() != null)
            user.setDateOfBirth(form.getDateOfBirth());
        if (form.getIdentificationNumber() != 0)
            user.setIdentificationNumber(form.getIdentificationNumber());
        if (form.getEmail() != null)
            user.setEmail(form.getEmail());

        save(user);

        return user;
    }

    public void delete(Long id) {
        userRepository.delete(findById(id));
    }

}

