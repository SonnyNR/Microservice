package sia.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import sia.domain.Professor;

@Repository
public interface ProfessorRepository extends CrudRepository<Professor, Long> {

}