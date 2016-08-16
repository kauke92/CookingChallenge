package au.usyd.elec5619.service;

import java.sql.Date;

import org.apache.commons.logging.LogFactory;
import org.hibernate.validator.internal.util.logging.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import au.usyd.elec5619.dao.LoginDao;
import au.usyd.elec5619.domain.Guide;
import au.usyd.elec5619.domain.User;

@Component
public class GuideValidator implements Validator {
	@Autowired
	LoginDao loginDao;
	
	@Override
	public boolean supports(Class clazz) {
		//return Guide.class.equals(clazz);
		//return Shop.class.isAssignableFrom(clazz);
		//source http://fruzenshtein.com/spring-mvc-validator-initbinder/
		return true;
	}

	@Override
	public void validate(Object obj, Errors e) {

		ValidationUtils.rejectIfEmpty(e, "guideTitle", "guide.title.empty");
		ValidationUtils.rejectIfEmpty(e, "guideDescription", "guide.description.empty");

		Guide guide = (Guide) obj;
		if (guide.getGuideCategory() == 0) {
			e.rejectValue("guideCategory", "guide.category.empty");

		}
		if (guide.getGuideTitle().length() > 100) {
			e.rejectValue("title", "guide.title.toolong");
		}
//		LoggedUserDetails user = (LoggedUserDetails) SecurityContextHolder
//				.getContext().getAuthentication().getPrincipal();
		
		
//		User databaseUser = loginDao.findByUserName(user.getUsername());
//		guide.setGuideAuthor(databaseUser);
//		databaseUser.addGuide(guide);
		
//		guide.setGuideAuthor(user.getUser());
//		user.getUser().addGuide(guide);
//
//		guide.setDateCreated(new Date(System.currentTimeMillis()));

	}

	

}
