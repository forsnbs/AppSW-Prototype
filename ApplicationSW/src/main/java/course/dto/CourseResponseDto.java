package course.dto;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;

import attachedfile.model.AttachedFile;
import course.enumtype.CourseCategoryType;
import course.enumtype.CourseClassroomType;
import course.enumtype.CourseLocationType;
import course.enumtype.CourseProgressType;
import course.model.Course;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;
import personcourse.model.PersonCourse;

@NoArgsConstructor
@Getter
@ToString
public class CourseResponseDto {
	
	private Long courseNo;
	
	private String courseName;
	
	private String courseUrl;
	
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
	
	private LocalDateTime courseRegisterdDatetime;
	
	private LocalDateTime courseModifiedDatetime;

	private List<AttachedFile> attachedFiles = new ArrayList<AttachedFile>();

	private List<PersonCourse> personCourses = new ArrayList<PersonCourse>();
	
	public CourseResponseDto(Course course) {
		super();
		this.courseNo = course.getCourseNo();
		this.courseName = course.getCourseName();
		this.courseUrl = course.getCourseUrl();
		this.courseCategory = course.getCourseCategory();
		this.courseProgress = course.getCourseProgress();
		this.courseCapacity = course.getCourseCapacity();
		this.courseStartDate = course.getCourseStartDate();
		this.courseEndDate = course.getCourseEndDate();
		this.courseLocation = course.getCourseLocation();
		this.courseClassroom = course.getCourseClassroom();
		this.courseInterviewPassNo = course.getCourseInterviewPassNo();
		this.courseCanceledReason = course.getCourseCanceledReason();
		this.courseRegisterdDatetime = course.getCourseRegisterdDatetime();
		this.courseModifiedDatetime = course.getCourseModifiedDatetime();
		this.attachedFiles = course.getAttachedFiles();
		this.personCourses = course.getPersonCourses();
	}
	
}
