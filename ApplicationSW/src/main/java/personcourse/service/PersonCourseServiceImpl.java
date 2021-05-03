package personcourse.service;

import org.springframework.security.acls.model.NotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import course.model.Course;
import course.repository.CourseRepository;
import lombok.RequiredArgsConstructor;
import person.model.Person;
import person.repository.PersonRepository;
import personcourse.model.PersonCourse;
import personcourse.repository.PersonCourseRepository;

@Service
@RequiredArgsConstructor
public class PersonCourseServiceImpl implements PersonCourseService{
	
	private final PersonCourseRepository personCourseRepository;

	private final CourseRepository courseRepository;
	
	private final PersonRepository personRepository;
	
	@Override
	@Transactional
	public void insertFirstAppInfo(Long personNo, Long courseNo) {
		Person person = personRepository.findById(personNo).orElseThrow(() -> new NotFoundException("신청자가 없습니다."));
		Course course = courseRepository.findById(courseNo).orElseThrow(() -> new NotFoundException("교육과정이 없습니다."));
		
		PersonCourse personCourse = new PersonCourse();
		personCourse.setPerson(person);
		personCourse.setCourse(course);
	
		personCourseRepository.save(personCourse);
	}
	
}
