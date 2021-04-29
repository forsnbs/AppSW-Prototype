package attachedfile.service;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.UUID;

import org.springframework.core.io.Resource;
import org.springframework.http.ResponseEntity;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import attachedfile.dto.AttachedFiledRegistrationDto;
import course.dto.CourseRegistrationDto;

public interface AttachedFileService {
	
	public void insertAttachedFile(Long courseNo, CourseRegistrationDto courseRegistrationDto, MultipartHttpServletRequest multipartRequest) throws FileNotFoundException, IllegalStateException, IOException;
	
//	public void uploadCourseAttachedFile(CourseRegistrationDto courseRegistrationDto, MultipartHttpServletRequest multipartRequest) throws IllegalStateException, IOException;
	
	public void insertCourseAttachedFile(Long courseNo, UUID uid, CourseRegistrationDto courseRegistrationDto, MultipartHttpServletRequest multipartRequest) throws FileNotFoundException;

	public void uploadCourseAttachedFile(UUID uid, CourseRegistrationDto courseRegistrationDto, MultipartHttpServletRequest multipartRequest) throws IllegalStateException, IOException;

	public ResponseEntity<Resource> downloadFile(Long fileNo) throws IOException;
}
