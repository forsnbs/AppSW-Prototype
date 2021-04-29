package attachedfile.dto;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;

import attachedfile.enumtype.AttachedFileCategoryType;
import attachedfile.model.AttachedFile;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@NoArgsConstructor
@Getter
@Setter
@ToString
public class AttachedFiledRegistrationDto {
	
	private String originalFilename;
	
	private String storedFilename;
	
	private Long filesize;
	
	private String storedFilepath;

	@Enumerated(EnumType.STRING)
	private AttachedFileCategoryType fileCategory;
	
	public AttachedFile toEntity() {
		AttachedFile attachedFile = AttachedFile.builder()
										.originalFilename(originalFilename)
										.storedFilename(storedFilename)
										.filesize(filesize)
										.storedFilepath(storedFilepath)
										.fileCategory(fileCategory)
										.build();
			return attachedFile;
	}
	
	@Builder
	public AttachedFiledRegistrationDto(String originalFilename, String storedFilename, Long filesize,
			String storedFilepath, AttachedFileCategoryType fileCategory) {
		super();
		this.originalFilename = originalFilename;
		this.storedFilename = storedFilename;
		this.filesize = filesize;
		this.storedFilepath = storedFilepath;
		this.fileCategory = fileCategory;
	}
	
	
}
