package course.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import course.enumtype.CourseProgressType;
import course.model.Course;

@Repository
public interface CourseRepository extends JpaRepository<Course, Long>{
	
	List<Course> findByCourseName(String courseName);

	List<Course> findByCourseNameOrderByCourseRegisterdDatetimeDesc(String courseName);

	List<Course> findByCourseProgress(CourseProgressType courseProgress);

}
