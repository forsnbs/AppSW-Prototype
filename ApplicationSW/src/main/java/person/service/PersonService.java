package person.service;

import person.dto.FirstApplicationDto;
import person.dto.MgrRegistrationReqDto;

public interface PersonService {
	
	public void insertManager(MgrRegistrationReqDto mgrRegistrationReqDto);

	public void insertFirstApplicant(FirstApplicationDto firstApplicationDto);
}
