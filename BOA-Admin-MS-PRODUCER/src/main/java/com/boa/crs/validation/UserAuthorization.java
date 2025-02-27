package com.boa.crs.validation;

import org.springframework.stereotype.Service;

import com.boa.crs.exception.NoUserLoggedInException;
import com.boa.crs.exception.UnauthorizedAccessException;
import com.boa.entity.LoginDetails;

/**
 * @author Naman, Purnima, Radha, Ramit, Sai, Vignesh
 *
 */
@Service
public class UserAuthorization {
	
	/**
	 * This is used to set authorization level of Admin
	 */
	public void adminAuthorization() {
		if(!"Admin".equalsIgnoreCase(LoginDetails.userRole)) {
			if(LoginDetails.userRole == null || LoginDetails.userRole.isEmpty())
				throw new NoUserLoggedInException();
			throw new UnauthorizedAccessException();
		}
	}
	
	/**
	 * This is used to set authorization level of Professor
	 */
	public void professorAuthorization() {
		if(!"Professor".equalsIgnoreCase(LoginDetails.userRole)) {
			if(LoginDetails.userRole == null || LoginDetails.userRole.isEmpty())
				throw new NoUserLoggedInException();
			throw new UnauthorizedAccessException();
		}
	}
	
	/**
	 * This is used to set authorization level of Student.
	 */
	public void studentAuthorization() {
		if(!"Student".equalsIgnoreCase(LoginDetails.userRole)) {
			if(LoginDetails.userRole == null || LoginDetails.userRole.isEmpty())
				throw new NoUserLoggedInException();
			throw new UnauthorizedAccessException();
		}
	}
}
