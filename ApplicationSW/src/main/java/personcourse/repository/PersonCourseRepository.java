package personcourse.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import personcourse.config.PersonCoursePK;
import personcourse.model.PersonCourse;

@Repository
public interface PersonCourseRepository extends JpaRepository<PersonCourse, PersonCoursePK> {

}
