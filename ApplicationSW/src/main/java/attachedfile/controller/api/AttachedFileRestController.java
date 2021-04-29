package attachedfile.controller.api;

import java.io.IOException;

import org.springframework.core.io.Resource;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import attachedfile.service.AttachedFileServiceImpl;
import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
public class AttachedFileRestController {
	
	private final AttachedFileServiceImpl attachedFileServiceImpl;
	
	@GetMapping(value = "/api/download/file/{fileNo}")
	public ResponseEntity<Resource> downloadAttachedFile(@PathVariable Long fileNo){
		ResponseEntity<Resource> resource = null; 
		try {
			resource = attachedFileServiceImpl.downloadFile(fileNo);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return resource;
	}
	
}
