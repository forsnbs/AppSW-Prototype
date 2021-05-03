package person.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.web.server.csrf.CsrfToken;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import course.model.Course;
import course.service.CourseServiceImpl;
import lombok.RequiredArgsConstructor;
import person.dto.FirstApplicationDto;
import person.dto.MgrRegistrationReqDto;
import person.service.PersonServiceImpl;
import personcourse.service.PersonCourseServiceImpl;

@Controller
@RequiredArgsConstructor
public class PersonController {
	
	private final CourseServiceImpl courseServiceImpl;
	
	private final PersonServiceImpl personServiceImpl;
	
	private final PersonCourseServiceImpl personCourseServiceImpl;
	
	@GetMapping(value = {"/", "/login"})
	public String viewLoginPage() {
		return "login";
	}
	
	@GetMapping(value = "/logout")
	public String logout() {
		return "login";
	}
	
	@GetMapping(value = "/main")
	public String viewMainPage(Model model) {
		model.addAttribute("courseProgress", "모집진행");
		model.addAttribute("courseList", courseServiceImpl.getCourseListByCourseProgress("진행예정"));
		return "main";
	}
	
	@GetMapping(value = "/managers")
	public String viewRegisterManagerPage() {
		return "managerRegistrationForm";
	}
	
	@PostMapping(value = "/managers")
	public String registerManager(MgrRegistrationReqDto mgrRegistrationReqDto, HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		personServiceImpl.insertManager(mgrRegistrationReqDto);
		return "main";
	}
	
	@GetMapping(value = "/application/{courseUrl}")
	public String viewApplicationPage(Model model, @PathVariable String courseUrl) {
		model.addAttribute("course", courseServiceImpl.getCourseByCourseUrl(courseUrl));
		return "application";
	}
	
	@PostMapping(value = "/application")
	public String submitFirstApplication(FirstApplicationDto firstApplicationDto, @RequestParam("info") Long courseNo) {
		Long personNo = personServiceImpl.insertFirstApplicant(firstApplicationDto);
		personCourseServiceImpl.insertFirstAppInfo(personNo, courseNo);
		return "redirect:https://playdata.io/thankyou";
	}
}

