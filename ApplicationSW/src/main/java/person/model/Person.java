package person.model;

import java.time.LocalDate;
import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import person.enumtype.FinalEduCategoryType;
import person.enumtype.PersonCategoryType;
import person.enumtype.SystemAuthorityType;

@NoArgsConstructor
@Getter
@Entity
public class Person {
	
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long personNo;
	
	private String personName;
	
	private String personEmail;
	
	private String personCellphoneNo;
	
	private int personAge;
	
	private LocalDate personBirthDate;
	
	private String personRoadAddress;
	
	@Enumerated(EnumType.STRING)
	private PersonCategoryType personCategory;
	
	private String password;
	
	private boolean enabled;
	
	@CreationTimestamp
	private LocalDateTime registerdDatetime;
	
	@UpdateTimestamp
	private LocalDateTime lastAccessDatetime;
	
	private int ncsScore;
	
	@Enumerated(EnumType.STRING)
	private SystemAuthorityType systemAuthority;
	
	private String finalEduSchoolName;
	
	private String finalEduMajorOne;
	
	private String finalEduMajorTwo;
	
	private LocalDate finalEduEntryDate;
	
	private LocalDate finalEduGraduationDate;
	
	private char finalEduGraduationFlag;
	
	private double fianlEduGradePoint;
	
	@Enumerated(EnumType.STRING)
	private FinalEduCategoryType finalEduCategory;
	
	@Builder
	public Person(Long personNo, String personName, String personEmail, String personCellphoneNo, int personAge,
			LocalDate personBirthDate, String personRoadAddress, PersonCategoryType personCategory, String password,
			boolean enabled, LocalDateTime registerdDatetime, LocalDateTime lastAccessDatetime, int ncsScore,
			SystemAuthorityType systemAuthority, String finalEduSchoolName, String finalEduMajorOne,
			String finalEduMajorTwo, LocalDate finalEduEntryDate, LocalDate finalEduGraduationDate,
			char finalEduGraduationFlag, double fianlEduGradePoint, FinalEduCategoryType finalEduCategory) {
		super();
		this.personNo = personNo;
		this.personName = personName;
		this.personEmail = personEmail;
		this.personCellphoneNo = personCellphoneNo;
		this.personAge = personAge;
		this.personBirthDate = personBirthDate;
		this.personRoadAddress = personRoadAddress;
		this.personCategory = personCategory;
		this.password = password;
		this.enabled = enabled;
		this.registerdDatetime = registerdDatetime;
		this.lastAccessDatetime = lastAccessDatetime;
		this.ncsScore = ncsScore;
		this.systemAuthority = systemAuthority;
		this.finalEduSchoolName = finalEduSchoolName;
		this.finalEduMajorOne = finalEduMajorOne;
		this.finalEduMajorTwo = finalEduMajorTwo;
		this.finalEduEntryDate = finalEduEntryDate;
		this.finalEduGraduationDate = finalEduGraduationDate;
		this.finalEduGraduationFlag = finalEduGraduationFlag;
		this.fianlEduGradePoint = fianlEduGradePoint;
		this.finalEduCategory = finalEduCategory;
	}
}
