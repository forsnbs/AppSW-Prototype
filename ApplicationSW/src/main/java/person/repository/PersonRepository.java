package person.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import person.model.Person;

@Repository
public interface PersonRepository extends JpaRepository<Person, Long>{
	
	Optional<Person> findByPersonEmail(String personEmail);
	
}
