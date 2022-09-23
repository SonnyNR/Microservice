package sia.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sia.domain.User;
import sia.repository.UserRepository;

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

    public User save(User user)
    {
        return userRepository.save(user);
    }

    public User findByEmail(String email)
    {
        return userRepository.findByEmail(email);
    }

    public User findById(Long id) {
        return userRepository.findUserById(id);
    }

    public String getRoleUser(String email) {

        User user = findByEmail(email);

        String role =
                user
                        .getClass()
                        .getName()
                        .replace("sia.domain.user.","")
                        .toLowerCase(Locale.ROOT);

        return role;
    }

    public void delete(String email) {
        userRepository.delete(findByEmail(email));
    }

}

