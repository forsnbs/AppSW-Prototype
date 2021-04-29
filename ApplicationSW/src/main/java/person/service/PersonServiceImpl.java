package person.service;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import lombok.RequiredArgsConstructor;
import person.dto.FirstApplicationDto;
import person.dto.MgrRegistrationReqDto;
import person.enumtype.PersonCategoryType;
import person.repository.PersonRepository;

@Service
@RequiredArgsConstructor
public class PersonServiceImpl implements PersonService{
	
	private final PersonRepository personRepository;
	
	private final PasswordEncoder passwordEncoder;
	
	@Override
	@Transactional
	public void insertManager(MgrRegistrationReqDto mgrRegistrationReqDto) {
		mgrRegistrationReqDto.setPersonCategory(PersonCategoryType.MANAGER);
		mgrRegistrationReqDto.setPassword(passwordEncoder.encode(mgrRegistrationReqDto.getPassword()));
		personRepository.save(mgrRegistrationReqDto.toEntity());
	}
	
	@Override
	@Transactional
	public void insertFirstApplicant(FirstApplicationDto firstApplicationDto) {
		personRepository.save(firstApplicationDto.toEntity());
	}
}
