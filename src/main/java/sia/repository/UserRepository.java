package sia.repository;

import org.springframework.data.repository.CrudRepository;
import sia.domain.User;

public interface UserRepository extends CrudRepository<User, Long>
{
    User findUserById(Long id);
    User findByEmail(String email);

}
