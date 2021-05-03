package personcourse.config;

import java.io.Serializable;

import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@EqualsAndHashCode
public class PersonCoursePK implements Serializable {
	private static final long serialVersionUID = 7343847664879702696L;
	
	private Long person;
	private Long course;
}
