package person.dto;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import person.enumtype.PersonCategoryType;
import person.enumtype.SystemAuthorityType;
import person.model.Person;

@NoArgsConstructor
@Getter
@Setter
@ToString
public class MgrRegistrationReqDto {
	
	private String personName;
	
	private String personEmail;
	
	private String password;
	
	private boolean enabled;
	
	@Enumerated(EnumType.STRING)
	private PersonCategoryType personCategory;
	
	@Enumerated(EnumType.STRING)
	private SystemAuthorityType systemAuthority;
	
	
	public Person toEntity() {
		Person person = Person.builder()
						.personName(personName)
						.personEmail(personEmail)
						.password(password)
						.enabled(enabled)
						.build();
		return person;
	}
}
