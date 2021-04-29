package person.controller.api;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;
import person.dto.FirstApplicationDto;
import person.service.PersonServiceImpl;

@RestController
@RequiredArgsConstructor
public class PersonRestController {
	
	private final PersonServiceImpl personServiceImpl;
	
	@PostMapping(value = "/applicants")
	public void submitFirstApplication(@RequestBody FirstApplicationDto firstApplicationDto) {
		personServiceImpl.insertFirstApplicant(firstApplicationDto);
	}
	
}
