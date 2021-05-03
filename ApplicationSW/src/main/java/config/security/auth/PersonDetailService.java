package config.security.auth;

import org.springframework.security.acls.model.NotFoundException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;
import person.model.Person;
import person.repository.PersonRepository;

@Service
@RequiredArgsConstructor
public class PersonDetailService implements UserDetailsService{
	
//	@Autowired
	private final PersonRepository personRepository;
	
	@Override
	public UserDetails loadUserByUsername(String personEmail) throws UsernameNotFoundException {
		System.out.println(personEmail);
		Person person = personRepository.findByPersonEmail(personEmail)
														.orElseThrow(() -> new NotFoundException(personEmail));
		return new PersonDetail(person);
	}
}
