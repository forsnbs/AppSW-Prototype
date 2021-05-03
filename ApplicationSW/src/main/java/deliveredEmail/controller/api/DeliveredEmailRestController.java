package deliveredEmail.controller.api;

import java.io.IOException;

import javax.mail.MessagingException;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import deliveredEmail.dto.DeliveredEmailDto;
import deliveredEmail.service.DeliveredEmailServiceImpl;
import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
public class DeliveredEmailRestController {
	
	private final DeliveredEmailServiceImpl deliveredEmailServiceImpl;
	
	@PostMapping(value = "/api/email", consumes = MediaType.APPLICATION_JSON_VALUE)
	public void sendDeliveredEmail(@RequestBody DeliveredEmailDto deliveredEmailDto) {
		try {
			deliveredEmailServiceImpl.sendMail(deliveredEmailDto);
		} catch (MessagingException | IOException e) {
			e.printStackTrace();
		}
	}
	
}
