package personcourse.model;

import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import course.model.Course;
import deliveredEmail.enumtype.DeliveredEmailCategoryType;
import lombok.Builder;
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
	@ManyToOne(targetEntity = Person.class ,fetch = FetchType.LAZY)
	@JoinColumn(name = "person_no")
	private Person person;
	
	@Id
	@ManyToOne(targetEntity = Course.class ,fetch = FetchType.LAZY)
	@JoinColumn(name = "course_no")
	private Course course;
	
	@CreationTimestamp
	private LocalDateTime relationStartDate;
	
	@UpdateTimestamp
	private LocalDateTime relationEndDate;
	
	private String detailApplicationFlag;
	
	private String interviewFlag;
	
	private String interviewPassFlag;
	
	private String deliveredEmailFlag;
	
	@Enumerated(EnumType.STRING)
	private DeliveredEmailCategoryType deliveredEmailCategory;
	
	private String courseDropoutReason;
	
	private LocalDateTime interviewDatetime;
	
	private String interviewLocation;
	
	private String interviewComment;
	
	private String courseDropoutFlag;
	
	private String unemploymentBenefitReceiptFlag;
	
	private String employmentInsuaranceJoinFlag;
	
	private String naeilbeaumCardIssueFlag;
	
	private String jobTrainingExperienceFlag;
	
	private String projectExperienceFlag;
	
	private String githubExperience;
	
	private int topcitScore;
	
	private String learningProgrammingLanguage;
	
	private String validItCertificate;
	
	@Builder
	public PersonCourse(Person person, Course course, LocalDateTime relationStartDate,
			LocalDateTime relationEndDate, String detailApplicationFlag, String interviewFlag, String interviewPassFlag,
			String deliveredEmailFlag, String courseDropoutReason, LocalDateTime interviewDatetime,
			String interviewLocation, String interviewComment, String courseDropoutFlag,
			String unemploymentBenefitReceiptFlag, String employmentInsuaranceJoinFlag, String naeilbeaumCardIssueFlag,
			String jobTrainingExperienceFlag, String projectExperienceFlag, String githubExperience, int topcitScore,
			String learningProgrammingLanguage, String validItCertificate) {
		super();
		this.person = person;
		this.course = course;
		this.relationStartDate = relationStartDate;
		this.relationEndDate = relationEndDate;
		this.detailApplicationFlag = detailApplicationFlag;
		this.interviewFlag = interviewFlag;
		this.interviewPassFlag = interviewPassFlag;
		this.deliveredEmailFlag = deliveredEmailFlag;
		this.courseDropoutReason = courseDropoutReason;
		this.interviewDatetime = interviewDatetime;
		this.interviewLocation = interviewLocation;
		this.interviewComment = interviewComment;
		this.courseDropoutFlag = courseDropoutFlag;
		this.unemploymentBenefitReceiptFlag = unemploymentBenefitReceiptFlag;
		this.employmentInsuaranceJoinFlag = employmentInsuaranceJoinFlag;
		this.naeilbeaumCardIssueFlag = naeilbeaumCardIssueFlag;
		this.jobTrainingExperienceFlag = jobTrainingExperienceFlag;
		this.projectExperienceFlag = projectExperienceFlag;
		this.githubExperience = githubExperience;
		this.topcitScore = topcitScore;
		this.learningProgrammingLanguage = learningProgrammingLanguage;
		this.validItCertificate = validItCertificate;
	}
	
	public void setCourse(Course course) {
		this.course = course;
	}
	
	public void setPerson(Person person) {
		this.person = person;
	}
}
