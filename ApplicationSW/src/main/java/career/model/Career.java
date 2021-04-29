package career.model;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import course.model.Course;
import lombok.Getter;
import lombok.NoArgsConstructor;
import person.model.Person;
import personcourse.config.PersonCoursePK;

@NoArgsConstructor
@Getter
@Entity
@IdClass(PersonCoursePK.class)
public class Career {
	
	@Id
	@ManyToOne(targetEntity = Course.class ,fetch = FetchType.LAZY)
	@JoinColumn(name = "person_no")
	private Person person;
	
	@Id
	@ManyToOne(targetEntity = Course.class ,fetch = FetchType.LAZY)
	@JoinColumn(name = "course_no")
	private Course course;
	
	private String careerInstitutionName;
	
	private String careerStartDate;
	
	private String careerEndDate;
	
	private String careerDepartmentName;
	
	private String careerTask;
	
	private String careerPosition;
	
}
