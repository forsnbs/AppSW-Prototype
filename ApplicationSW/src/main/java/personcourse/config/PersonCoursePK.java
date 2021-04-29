package personcourse.config;

import java.io.Serializable;

import course.model.Course;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import person.model.Person;

@NoArgsConstructor
@EqualsAndHashCode
public class PersonCoursePK implements Serializable {
	private static final long serialVersionUID = 7343847664879702696L;

	private Person person;
	private Course course;
}
