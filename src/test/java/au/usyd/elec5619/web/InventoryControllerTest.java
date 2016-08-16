package au.usyd.elec5619.web;


import java.util.Map;

import junit.framework.TestCase;

import org.springframework.web.servlet.ModelAndView;

import au.usyd.elec5619.service.SimpleUserManager;

public class InventoryControllerTest  extends TestCase {

	public void testHandleRequestView() throws Exception {
		ChallengeEntryController controller = new ChallengeEntryController();
		controller.setUserManager(new SimpleUserManager());
		ModelAndView modelAndView = controller.handleRequest(null, null);
		assertEquals("profile", modelAndView.getViewName());
		assertNotNull(modelAndView.getViewName());
		Map modelMap = (Map) modelAndView.getModel().get("model");
		String nowValue = (String) modelMap.get("now");
		assertNotNull(nowValue);
	}
}
