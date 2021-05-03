package course.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import attachedfile.service.AttachedFileServiceImpl;
import course.dto.CourseRegistrationDto;
import course.service.CourseServiceImpl;
import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
public class CourseController {
	
	private final CourseServiceImpl courseServiceImpl;
	
	private final AttachedFileServiceImpl attachedFileServiceImpl;
	
	@GetMapping(value = "/course")
	public String viewRegisgerCoursePage() {
		return "courseRegistration";
	}
	
	@PostMapping(value = "/course")
	public String registerCourse(CourseRegistrationDto courseRegistrationDto, MultipartHttpServletRequest multipartRequest) {
		Long courseNo = courseServiceImpl.insertCourse(courseRegistrationDto);
		try {
			attachedFileServiceImpl.insertAttachedFile(courseNo, courseRegistrationDto, multipartRequest);
		} catch (IllegalStateException | IOException e) {
			e.printStackTrace();
		}
		return "redirect:/main";
	}
	
	@GetMapping(value = "/course/{courseProgress}")
	public String viewMainPageByCourseProgress(Model model, @PathVariable String courseProgress) {
		model.addAttribute("coourseProgress", courseProgress);
		model.addAttribute("courseList", courseServiceImpl.getCourseListByCourseProgress(courseProgress));
		return "main";
	}
	
	@GetMapping(value = "/course/detail/{courseNo}")
	public String viewCourseDetailByCourseNo(Model model, @PathVariable Long courseNo) {
		model.addAttribute("course", courseServiceImpl.getCourseByCourseNo(courseNo));
		return "courseDetail";
	}
	
	@GetMapping(value = "/course/main/{courseNo}")
	public String viewCourseMainPage(Model model, @PathVariable Long courseNo) {
		model.addAttribute("course", courseServiceImpl.getCourseByCourseNo(courseNo));
		model.addAttribute("personCourse", courseServiceImpl.getCourseByCourseNo(courseNo).getPersonCourses());
		return "courseMain";
	}
	
}
