package com.boa.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.boa.entity.Registration;
import com.boa.repository.RegistrationRepository;

@Service
public class RegistrationService {

	@Autowired
	private RegistrationRepository RegistrationRepository;
	
	public List<Registration> getAllRegistrations() {
		return (List<Registration>) RegistrationRepository.findAll();
	}

	public Registration addRegistration( Registration Registration) {
		return RegistrationRepository.save(Registration);
	}

	public Registration getRegistrationById( Long id) {
		return RegistrationRepository.findById(id).orElse(null);
	}

	public Registration updateRegistration( Long id,  Registration updatedRegistration) {
		if (RegistrationRepository.existsById(id)) {
			updatedRegistration.setRegistrationId(id);
			return RegistrationRepository.save(updatedRegistration);
		}
		return null;
	}

	public void deleteRegistration( Long id) {
		RegistrationRepository.deleteById(id);
	}
}
