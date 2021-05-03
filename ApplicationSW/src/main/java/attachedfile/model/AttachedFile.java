package attachedfile.model;

import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import attachedfile.enumtype.AttachedFileCategoryType;
import course.model.Course;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;
import person.model.Person;
import personcourse.model.PersonCourse;

@NoArgsConstructor
@Getter
@Entity
@ToString
public class AttachedFile {
	
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long fileNo;
	
	@ManyToOne
	@JoinColumn(name = "course_no")
	private Course course;

	@ManyToOne
	@JoinColumn(name = "person_no")
	private Person person;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumns({
		@JoinColumn(name = "course_no", insertable = false, updatable = false),
		@JoinColumn(name = "person_no", insertable = false, updatable = false)
	})
	private PersonCourse personCourse;
	
	@Enumerated(EnumType.STRING)
	private AttachedFileCategoryType fileCategory;

	private String originalFilename;

	private String storedFilename;
	
	private String storedFilepath;

	private Long filesize;
	
	@CreationTimestamp
	private LocalDateTime storedDatetime;
	
	private Character fileDeletionFlag;
	
	@UpdateTimestamp
	private LocalDateTime fileDeletionDatetime;
	
	@Builder
	public AttachedFile(Long fileNo, Course course, PersonCourse personCourse, AttachedFileCategoryType fileCategory,
			String originalFilename, String storedFilename, String storedFilepath, Long filesize,
			LocalDateTime storedDatetime, Character fileDeletionFlag, LocalDateTime fileDeletionDatetime) {
		super();
		this.fileNo = fileNo;
		this.course = course;
		this.personCourse = personCourse;
		this.fileCategory = fileCategory;
		this.originalFilename = originalFilename;
		this.storedFilename = storedFilename;
		this.storedFilepath = storedFilepath;
		this.filesize = filesize;
		this.storedDatetime = storedDatetime;
		this.fileDeletionFlag = fileDeletionFlag;
		this.fileDeletionDatetime = fileDeletionDatetime;
	}
	
	public void setCourse(Course course) {
		this.course = course;
	}
	
}
