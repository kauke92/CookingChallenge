package au.usyd.elec5619.web;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import au.usyd.elec5619.service.ChallengeManager;
import au.usyd.elec5619.service.ReviewManager;

public class UserReviewController implements Controller {
	protected final Log logger = LogFactory.getLog(getClass());

    private ChallengeManager challengeManager;
    private ReviewManager reviewManager;
	@Override
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		String now = (new java.util.Date()).toString();
        logger.info("returning add review view on " + now);

        Map<String, Object> myModel = new HashMap<String, Object>();
        myModel.put("now", now);
        logger.info("ID of challenge is " + request.getParameter("id"));
        
        return new ModelAndView("redirect:/addreview");
	}
	
	public void setChallengeManager(ChallengeManager challengeManager) {
        this.challengeManager = challengeManager;
    }
    public void setReviewManager(ReviewManager reviewManager) {
        this.reviewManager = reviewManager;
    }
}
