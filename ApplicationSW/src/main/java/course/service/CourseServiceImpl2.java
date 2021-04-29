package course.service;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import course.dto.CourseRegistrationDto;
import course.dto.CourseResponseDto;
import course.enumtype.CourseProgressType;
import course.model.Course;
import course.repository.CourseRepository;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class CourseServiceImpl2 implements CourseService2 {
	
	private final CourseRepository courseRepository;
	
	@Override
	@Transactional
	public void insertCourse(CourseRegistrationDto courseRegistrationDto) {
		courseRepository.save(courseRegistrationDto.toEntity());
	}
	
	@Override
	@Transactional
	public List<CourseResponseDto> getAllCourseList() {
		List<CourseResponseDto> courseResponseDtos = new ArrayList<CourseResponseDto>();
		for (Course course : courseRepository.findAll()) {
			courseResponseDtos.add(new CourseResponseDto(course));
		}
		return courseResponseDtos;
	}
	
	@Override
	@Transactional
	public List<CourseResponseDto> getCourseListByCourseProgress(String courseProgress) {
		List<CourseResponseDto> courseResponseDtos = new ArrayList<CourseResponseDto>();
		CourseProgressType courseProgressType = null;
		
		if(courseProgress.equals(CourseProgressType.진행예정.toString())) {
			courseProgressType = CourseProgressType.진행예정; 
		}else if (courseProgress.equals(CourseProgressType.진행중.toString())) {
			courseProgressType = CourseProgressType.진행중;
		}else if (courseProgress.equals(CourseProgressType.진행완료.toString())) {
			courseProgressType = CourseProgressType.진행완료;
		}else if (courseProgress.equals(CourseProgressType.진행취소.toString())) {
			courseProgressType = CourseProgressType.진행취소;
		}
		
		for (Course course : courseRepository.findByCourseProgress(courseProgressType)) {
			courseResponseDtos.add(new CourseResponseDto(course));
		}
		
		return courseResponseDtos;
	}

//	@Transactional
//	@Override
//	public Course getCourseByCourseName(String courseName) {
//		Optional<List<Course>> courseList = Optional.ofNullable(courseRepository.findByCourseName(courseName));
//			courseList.orElseThrow(() -> new NotFoundException(courseName + "가 없습니다."));
//			if(courseList.get().size() < 2) {
//				return courseList.get().get(0);
//			}else {
//				return courseRepository.findByCourseNameOrderByCourseRegisterdDatetimeDesc(courseName).get(0);
//			}
//	}
	
}
