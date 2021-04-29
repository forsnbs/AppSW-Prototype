package attachedfile.service;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.core.io.InputStreamResource;
import org.springframework.core.io.Resource;
import org.springframework.http.ContentDisposition;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.acls.model.NotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import attachedfile.dto.AttachedFiledRegistrationDto;
import attachedfile.enumtype.AttachedFileCategoryType;
import attachedfile.model.AttachedFile;
import attachedfile.repository.AttachedFileRepository;
import course.dto.CourseRegistrationDto;
import course.repository.CourseRepository;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class AttachedFileServiceImpl implements AttachedFileService{
	
	private final AttachedFileRepository attachedFileRepository;
	
	private final CourseRepository courseRepository;
	
	private final String SAVE_FILE_BASE_PATH = "C:\\upload\\";
	
	@Override
	@Transactional
	public void insertAttachedFile(Long courseNo, CourseRegistrationDto courseRegistrationDto, MultipartHttpServletRequest multipartRequest) throws IllegalStateException, IOException {
		UUID uid = UUID.randomUUID();
		uploadCourseAttachedFile(uid, courseRegistrationDto, multipartRequest);
		insertCourseAttachedFile(courseNo, uid, courseRegistrationDto, multipartRequest);
	}
	
	@Override
	@Transactional
	public void uploadCourseAttachedFile(UUID uid, CourseRegistrationDto courseRegistrationDto, MultipartHttpServletRequest multipartRequest) throws IllegalStateException, IOException {
		AttachedFileCategoryType fileCategory = AttachedFileCategoryType.커리큘럼;
		String saveFilePath = SAVE_FILE_BASE_PATH + courseRegistrationDto.getCourseName() + "\\" + fileCategory;
		List<MultipartFile> multipartFiles = multipartRequest.getFiles("attachedFile");
		if(multipartFiles.isEmpty()) {
			throw new FileNotFoundException();
		}else {
			for(MultipartFile multipartFile : multipartFiles) {
				File file = new File(saveFilePath + "\\" + uid.toString() + multipartFile.getOriginalFilename());
				if(!file.getParentFile().exists()) {
					if(file.getParentFile().mkdirs()) {
						multipartFile.transferTo(file);
					}
				}else {
					multipartFile.transferTo(file);
				}
			}	
		}
	}
	
	@Override
	@Transactional
	public void insertCourseAttachedFile(Long courseNo, UUID uid, CourseRegistrationDto courseRegistrationDto, MultipartHttpServletRequest multipartRequest) throws FileNotFoundException {
		AttachedFileCategoryType fileCategory = AttachedFileCategoryType.커리큘럼;
		String saveFilePath = SAVE_FILE_BASE_PATH + courseRegistrationDto.getCourseName() + "\\" + fileCategory;
		List<MultipartFile> multipartFiles = multipartRequest.getFiles("attachedFile");
		List<AttachedFile> files = new ArrayList<AttachedFile>();
		if(multipartFiles.isEmpty()) {
			throw new FileNotFoundException();
		}else {
			for(MultipartFile multipartFile : multipartFiles) {
				AttachedFile attachedFile = new AttachedFiledRegistrationDto(multipartFile.getOriginalFilename(), uid.toString() + multipartFile.getOriginalFilename(), multipartFile.getSize(), saveFilePath, fileCategory).toEntity();
				attachedFile.setCourse(courseRepository.findById(courseNo).get());
				files.add(attachedFile);
			}
			attachedFileRepository.saveAll(files);
		}
	}
	
	@Override
	@Transactional
	public ResponseEntity<Resource> downloadFile(Long fileNo) throws IOException {
		
		Optional<AttachedFile> attachedfile = Optional.ofNullable(attachedFileRepository.findById(fileNo).orElseThrow(() -> new NotFoundException("존재하지 않는 파일입니다.")));
		Path path = Paths.get(attachedfile.get().getStoredFilepath() + "\\" + attachedfile.get().getStoredFilename());
		String contentType = Files.probeContentType(path);
		HttpHeaders headers = new HttpHeaders();
		headers.add(HttpHeaders.CONTENT_TYPE, contentType);
		headers.setContentDisposition(ContentDisposition.builder("attachment")
										.filename(attachedfile.get().getOriginalFilename(), StandardCharsets.UTF_8)
										.build()
									 );
		Resource resource = new InputStreamResource(Files.newInputStream(path));
		return new ResponseEntity<Resource>(resource, headers, HttpStatus.OK);
	}
	
}
