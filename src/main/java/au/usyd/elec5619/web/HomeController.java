package au.usyd.elec5619.web;

import java.security.Principal;
import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


/**
 * Handles requests for the application home page.
 */
@Controller
@Transactional
public class HomeController {
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	/**
	 * Simply selects the home view to render by returning its name.
	 */
	private SessionFactory sessionFactory;
	
	@Autowired
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {
		
//		User u = new User();
//		u.setUsername("kauke92");
//		u.setPassword("12345678");
//		u.setEnabled(true);
//		this.sessionFactory.getCurrentSession().save(u);
		
		logger.info("Welcome home! The client locale is {}.", locale);
		
		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);
		
		String formattedDate = dateFormat.format(date);
		
		model.addAttribute("serverTime", formattedDate );
		
		return "home";
	}
	@RequestMapping("/secured/mypage")
	public String mypage(Model model, Principal principal) {
		String userName = principal.getName();
		model.addAttribute("message", "Hi " + userName + ", Welcome to 'Spring Security Custom Login Form Example'");
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		String name = auth.getName(); 
		model.addAttribute("name", name);
		return "secured/mypage";
	}
	
	@RequestMapping(value = "/logoutPage", method = RequestMethod.GET)
	public String logoutPage() {
		
		return "logoutPage";
	}
	
	
	@RequestMapping(value = "/loginPage", method = RequestMethod.GET)
	public String loginPage() {
		return "loginPage";
	}
}
