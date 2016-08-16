package au.usyd.elec5619.service;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;
import au.usyd.elec5619.domain.Guide;

public class GuideCategoryValidator implements Validator {

	public boolean supports(Class<?> paramClass) {
		return Guide.class.equals(paramClass);

	}
	public void validate(Object obj, Errors errors) {

		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "guideCategoryName", "valid.guideCategoryName");

	}

}
