package deliveredEmail.service;

import java.io.IOException;
import java.util.List;

import javax.mail.MessagingException;

import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import attachedfile.model.AttachedFile;
import config.mail.MailHandler;
import course.service.CourseServiceImpl;
import deliveredEmail.dto.DeliveredEmailDto;
import lombok.RequiredArgsConstructor;


@Service
@RequiredArgsConstructor
public class DeliveredEmailServiceImpl implements DeliveredEmailService{
	
	private final CourseServiceImpl courseServiceImpl;
	
	private JavaMailSender javaMailSender;
	
	private static final String FROM_ADDRESS = "superb.the.data@gmail.com";
	
	public void sendMail(DeliveredEmailDto deliveredEmailDto) throws MessagingException, IOException {
		MailHandler mailHandler = new MailHandler(javaMailSender);

		// 보내는 사람
		mailHandler.setFrom(FROM_ADDRESS);
		
		// 받는 사람
		mailHandler.setTo(deliveredEmailDto.getAddress());
		
		// 제목
		mailHandler.setSubject(deliveredEmailDto.getTitle());
		
		// 내용
		mailHandler.setText(deliveredEmailDto.getMessage(), true);
		
		// 안내메일 여부 확인 : 안내메일은 파일첨부 필요 없음
		if (deliveredEmailDto.getCategory().equals("면접일정")) {
			mailHandler.send();
		}else {
    		// 첨부파일
    		List<AttachedFile> files = courseServiceImpl.getCourseByCourseNo(deliveredEmailDto.getCourseNo()).getAttachedFiles();
    		if (files.size() == 0) {
        		// 전송
        		mailHandler.send();
    		} else {
    			for(AttachedFile file : files) {
    				mailHandler.setAttachment(file.getOriginalFilename(), file.getStoredFilepath() + "\\" + file.getStoredFilename());
    			}
    			// 전송
    			mailHandler.send();
    		}
		}
	}
}
