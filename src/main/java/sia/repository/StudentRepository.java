package sia.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import sia.domain.Student;

@Repository
public interface StudentRepository extends CrudRepository<Student, Long> {

}

