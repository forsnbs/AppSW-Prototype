package course.dto;

import java.time.LocalDate;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;

import org.springframework.format.annotation.DateTimeFormat;

import course.enumtype.CourseCategoryType;
import course.enumtype.CourseClassroomType;
import course.enumtype.CourseLocationType;
import course.enumtype.CourseProgressType;
import course.model.Course;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@NoArgsConstructor
@Getter
@Setter
@ToString
public class CourseRegistrationDto {
	
	private String courseName;

	@Enumerated(EnumType.STRING)
	private CourseCategoryType courseCategory;
	
	@Enumerated(EnumType.STRING)
	private CourseProgressType courseProgress;
	
	private int courseCapacity;
	
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private LocalDate courseStartDate;
	
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private LocalDate courseEndDate;
	
	@Enumerated(EnumType.STRING)
	private CourseLocationType courseLocation;
	
	@Enumerated(EnumType.STRING)
	private CourseClassroomType courseClassroom;
	
	public Course toEntity() {
		Course course = Course.builder()
							.courseName(courseName)
							.courseCategory(courseCategory)
							.courseProgress(courseProgress)
							.courseCapacity(courseCapacity)
							.courseStartDate(courseStartDate)
							.courseEndDate(courseEndDate)
							.courseLocation(courseLocation)
							.courseClassroom(courseClassroom)
							.build();
		return course;
	}
	
}
