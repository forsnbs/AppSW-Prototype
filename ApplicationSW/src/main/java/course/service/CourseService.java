package course.service;

import java.util.List;

import course.dto.CourseRegistrationDto;
import course.dto.CourseResponseDto;
import course.model.Course;

public interface CourseService {
	
	Long insertCourse(CourseRegistrationDto courseRegistrationDto);

	List<CourseResponseDto> getAllCourseList();
	
	List<CourseResponseDto> getCourseListByCourseProgress(String courseProgress);
	
	Course getCourseByCourseNo(Long courseNo);
	
	Course getCourseByCourseName(String courseName);

	Course getCourseByCourseUrl(String courseUrl);
	
	
}
