package config.mail;

import java.io.File;
import java.io.IOException;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

import org.springframework.core.io.FileSystemResource;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;

public class MailHandler {
	private JavaMailSender javaMailSender;
	private MimeMessage message;
	private MimeMessageHelper messageHelper;
	
	public MailHandler(JavaMailSender javaMailSender) throws MessagingException{
		this.javaMailSender = javaMailSender;
		message = javaMailSender.createMimeMessage();
		messageHelper = new MimeMessageHelper(message, true, "UTF-8");
	}
	
	// 보내는 사람
	public void setFrom(String fromEmail) throws MessagingException{
		messageHelper.setFrom(fromEmail);
	}
	
	// 받는 사람
	public void setTo(String toEmail) throws MessagingException{
		messageHelper.setTo(toEmail);
	}
	
	// 제목
	public void setSubject(String subject) throws MessagingException{
		messageHelper.setSubject(subject);
	}
	
	// 메일 내용
	public void setText(String text, boolean useHTML) throws MessagingException{
		messageHelper.setText(text, useHTML);
	}
	
	// 첨부 파일
	public void setAttachment(String filename, String filepath) throws MessagingException, IOException{
		File file = new File(filepath);
		FileSystemResource fsr = new FileSystemResource(file);
		
		messageHelper.addAttachment(filename, fsr);
	}
	
	// 이미지 삽입
//    public void setInline(String contentId, String pathToInline) throws MessagingException, IOException {
//        File file = new ClassPathResource(pathToInline).getFile();
//        FileSystemResource fsr = new FileSystemResource(file);
//
//        messageHelper.addInline(contentId, fsr);
//    }
    
	// 발송
    public void send() {
        try {
        	javaMailSender.send(message);
        }catch(Exception e) {
            e.printStackTrace();
        }
    }
}
