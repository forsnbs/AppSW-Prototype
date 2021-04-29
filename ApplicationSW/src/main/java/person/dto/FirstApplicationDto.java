package person.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import person.model.Person;

@NoArgsConstructor
@Getter
@Setter
@ToString
public class FirstApplicationDto {
	
	private String personName;
	
	private String personEmail;
	
	private String personCellphoneNo;
	
	private int personAge;
	
	public Person toEntity() {
		Person person = Person.builder()
						.personName(personName)
						.personEmail(personEmail)
						.personCellphoneNo(personCellphoneNo)
						.personAge(personAge)
						.build();
		return person;
	}
}
