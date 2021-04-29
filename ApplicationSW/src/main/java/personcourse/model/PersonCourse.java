package personcourse.model;

import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import course.model.Course;
import lombok.Getter;
import lombok.NoArgsConstructor;
import person.model.Person;
import personcourse.config.PersonCoursePK;

@NoArgsConstructor
@Getter
@Entity
@IdClass(PersonCoursePK.class)
public class PersonCourse {
	
	@Id
	@ManyToOne(targetEntity = Course.class ,fetch = FetchType.LAZY)
	@JoinColumn(name = "person_no")
	private Person person;
	
	@Id
	@ManyToOne(targetEntity = Course.class ,fetch = FetchType.LAZY)
	@JoinColumn(name = "course_no", insertable = false, updatable = false)
	private Course course;
	
	@ManyToOne(targetEntity = Person.class ,fetch = FetchType.LAZY)
	@JoinColumn(name = "person_no", insertable = false, updatable = false)
	private Person interviewer;
	
	@CreationTimestamp
	private LocalDateTime relationStartDate;
	
	@UpdateTimestamp
	private LocalDateTime relationEndDate;
	
	private char detailApplicationFlag;
	
	private char interviewFlag;
	
	private char interviewPassFlag;
	
	private char deliveredEmailFlag;
	
	private String courseDropoutReason;
	
	private LocalDateTime interviewDatetime;
	
	private String interviewLocation;
	
	private String interviewComment;
	
	private char courseDropoutFlag;
	
	private char unemploymentBenefitReceiptFlag;
	
	private char employmentInsuaranceJoinFlag;
	
	private char naeilbeaumCardIssueFlag;
	
	private char jobTrainingExperienceFlag;
	
	private char projectExperienceFlag;
	
	private String githubExperience;
	
	private int topcitScore;
	
	private String learningProgrammingLanguage;
	
	private String validItCertificate;
	
}
