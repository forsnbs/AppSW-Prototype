package config.security.auth;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import person.model.Person;

public class PersonDetail implements UserDetails, Serializable{
	
	private static final long serialVersionUID = 4173261328064099204L;

	private Person person;
	
	private final String ROLE_PREFIX = "ROLE_";
	
	public PersonDetail(Person person) {
		this.person = person;
	}
	
	public Person getPerson() {
		return person;
	}
	
	public String getPersonName() {
		return person.getPersonName();
	}
	
	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		Collection<GrantedAuthority> collectors = new ArrayList<>();
		collectors.add(() -> {return ROLE_PREFIX + person.getSystemAuthority();});
		return collectors;
	}
	
	@Override
	public String getPassword() {
		return person.getPassword();
	}

	@Override
	public String getUsername() {
		return person.getPersonEmail();
	}

	@Override
	public boolean isAccountNonExpired() {
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		return true;
	}

	@Override
	public boolean isEnabled() {
		return person.isEnabled();
	}
}
