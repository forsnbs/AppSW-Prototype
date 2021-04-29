package person.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import course.service.CourseServiceImpl;
import lombok.RequiredArgsConstructor;
import person.dto.MgrRegistrationReqDto;
import person.service.PersonServiceImpl;

@Controller
@RequiredArgsConstructor
public class PersonController {
	
	private final CourseServiceImpl courseServiceImpl;
	
	private final PersonServiceImpl personServiceImpl;
	
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
	
	@GetMapping(value = "/application")
	public String viewApplicationPage() {
		return "application";
	}
	
	
}
