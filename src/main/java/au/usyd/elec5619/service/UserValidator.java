package au.usyd.elec5619.service;

import org.apache.commons.logging.LogFactory;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import au.usyd.elec5619.domain.User;


public class UserValidator implements Validator {

	
	public boolean supports(Class clazz) {
		return UserManager.class.equals(clazz);
	}
	
	public void validate(Object obj, Errors errors) {
		User use = (User) obj;
		
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "password", "required.password", "Field name is required.");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "password", "required.confirmpassword", "Field name is required.");
		if(!use.getPassword().equals(use.getConfirmpassword())) {
			errors.rejectValue("password", "notmatch.password");
		}
		
	}
	
}