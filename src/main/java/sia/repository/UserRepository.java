package sia.repository;

import org.springframework.data.repository.CrudRepository;
import sia.domain.User;

import java.util.List;

public interface UserRepository extends CrudRepository<User, Long>
{
    User findUserById(Long id);
    User findByEmail(String email);
    List<User> findAll();


}
