package com.boa.restcontroller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.boa.entity.Registration;
import com.boa.service.RegistrationService;

@RestController
@RequestMapping("/api2")
public class RegistrationController {

	@Autowired
	private RegistrationService RegistrationService;

	@GetMapping("/getAllRegistrations")
	public List<Registration> getAllRegistrations() {
		return RegistrationService.getAllRegistrations();
	}

	@PostMapping("/addRegistration")
	public Registration addRegistration(@RequestBody Registration Registration) {
		return RegistrationService.addRegistration(Registration);
	}

	@GetMapping("/getRegistrationById/{id}")
	public Registration getRegistrationById(@PathVariable Long id) {
		return RegistrationService.getRegistrationById(id);
	}

	@PutMapping("/updateRegistration/{id}")
	public Registration updateRegistration(@PathVariable Long id, @RequestBody Registration updatedRegistration) {
		return RegistrationService.updateRegistration(id, updatedRegistration);

	}

	@DeleteMapping("/deleteRegistration/{id}")
	public void deleteRegistration(@PathVariable Long id) {
		RegistrationService.deleteRegistration(id);
	}
}
