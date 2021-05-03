package person.controller.api;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.view.RedirectView;

import lombok.RequiredArgsConstructor;
import person.dto.FirstApplicationDto;
import person.dto.MgrRegistrationReqDto;
import person.service.PersonServiceImpl;

@RestController
@RequiredArgsConstructor
public class PersonRestController {
	
	private final PersonServiceImpl personServiceImpl;
	

}
