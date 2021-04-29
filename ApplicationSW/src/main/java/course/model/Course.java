package course.model;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import attachedfile.model.AttachedFile;
import course.enumtype.CourseCategoryType;
import course.enumtype.CourseClassroomType;
import course.enumtype.CourseLocationType;
import course.enumtype.CourseProgressType;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import personcourse.model.PersonCourse;

@NoArgsConstructor
@Getter
@Entity
public class Course {
	
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long courseNo;
	
	private String courseName;
	
	@Enumerated(EnumType.STRING)
	private CourseCategoryType courseCategory;
	
	@Enumerated(EnumType.STRING)
	private CourseProgressType courseProgress;

	private int courseCapacity;
	
	private LocalDate courseStartDate;
	
	private LocalDate courseEndDate;
	
	@Enumerated(EnumType.STRING)
	private CourseLocationType courseLocation;
	
	@Enumerated(EnumType.STRING)
	private CourseClassroomType courseClassroom;
	
	private int courseInterviewPassNo;
	
	private String courseCanceledReason;
	
	@CreationTimestamp
	private LocalDateTime courseRegisterdDatetime;
	
	@UpdateTimestamp
	private LocalDateTime courseModifiedDatetime;

	@OneToMany(mappedBy = "course")
	private List<AttachedFile> attachedFiles = new ArrayList<AttachedFile>();

	@OneToMany(mappedBy = "course")
	private List<PersonCourse> personCourses = new ArrayList<PersonCourse>();
	
	@Builder
	public Course(Long courseNo, String courseName, CourseCategoryType courseCategory,
			CourseProgressType courseProgress, int courseCapacity, LocalDate courseStartDate, LocalDate courseEndDate,
			CourseLocationType courseLocation, CourseClassroomType courseClassroom, int courseInterviewPassNo, String courseCanceledReason,
			LocalDateTime courseRegisterdDatetime, LocalDateTime courseModifiedDatetime,
			List<AttachedFile> attachedFiles, List<PersonCourse> personCourses) {
		super();
		this.courseNo = courseNo;
		this.courseName = courseName;
		this.courseCategory = courseCategory;
		this.courseProgress = courseProgress;
		this.courseCapacity = courseCapacity;
		this.courseStartDate = courseStartDate;
		this.courseEndDate = courseEndDate;
		this.courseLocation = courseLocation;
		this.courseClassroom = courseClassroom;
		this.courseInterviewPassNo = courseInterviewPassNo;
		this.courseCanceledReason = courseCanceledReason;
		this.courseRegisterdDatetime = courseRegisterdDatetime;
		this.courseModifiedDatetime = courseModifiedDatetime;
		this.attachedFiles = attachedFiles;
		this.personCourses = personCourses;
	}
	
	public void addAttachedFile(AttachedFile attachedFile) {
		attachedFiles.add(attachedFile);
	}
}
