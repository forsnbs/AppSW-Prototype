package course.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.persistence.EnumType;
import javax.transaction.Transactional;

import org.springframework.security.acls.model.NotFoundException;
import org.springframework.stereotype.Service;

import course.dto.CourseRegistrationDto;
import course.dto.CourseResponseDto;
import course.enumtype.CourseProgressType;
import course.model.Course;
import course.repository.CourseRepository;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class CourseServiceImpl implements CourseService{
	
	private final CourseRepository courseRepository;
	
	@Override
	@Transactional
	public Long insertCourse(CourseRegistrationDto courseRegistrationDto) {
		Optional<CourseRegistrationDto> ofNullable = Optional.ofNullable(courseRegistrationDto);
		courseRegistrationDto = ofNullable.orElseThrow(() -> new NotFoundException("등록 하고자 하는 과정이 없습니다."));
		return courseRepository.save(courseRegistrationDto.toEntity()).getCourseNo();
	}

	@Override
	@Transactional
	public Course getCourseByCourseName(String courseName) {
		Optional<List<Course>> courseList = Optional.ofNullable(courseRepository.findByCourseName(courseName));
			courseList.orElseThrow(() -> new NotFoundException(courseName + "가 없습니다."));
			if(courseList.get().size() < 2) {
				return courseList.get().get(0);
			}else {
				return courseRepository.findByCourseNameOrderByCourseRegisterdDatetimeDesc(courseName).get(0);
			}
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

	@Override
	@Transactional
	public Course getCourseByCourseNo(Long courseNo) {
		Course course = courseRepository.findById(courseNo).orElseThrow(() -> new NotFoundException("등록 과정이 없습니다."));
		System.out.println(course.getCourseName());
		return course;
	}
	
	@Override
	@Transactional
	public Course getCourseByCourseUrl(String courseUrl) {
		Course course = courseRepository.findByCourseUrl(courseUrl).orElseThrow(() -> new NotFoundException("해당 과정이 없습니다."));
		return course;
	}
	
}
