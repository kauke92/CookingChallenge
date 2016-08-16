package au.usyd.elec5619.web;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import au.usyd.elec5619.domain.Challenge;
import au.usyd.elec5619.domain.Review;
import au.usyd.elec5619.service.ChallengeManager;
import au.usyd.elec5619.service.ReviewManager;

public class ViewSingleChallengeController implements Controller {
	protected final Log logger = LogFactory.getLog(getClass());

    private ChallengeManager challengeManager;
    private ReviewManager reviewManager;

    public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String now = (new java.util.Date()).toString();
        logger.info("returning preview challenges view on " + now);

        Map<String, Object> myModel = new HashMap<String, Object>();
        myModel.put("now", now);
        String cid = request.getParameter("id");
        int id = Integer.parseInt(cid);
        ArrayList<Challenge> temp = new ArrayList<Challenge>();
        temp.add(this.challengeManager.getChallengeById(id));
        myModel.put("challenges", temp);
        List <Review> temps = this.reviewManager.getReviewByChallengeId(id);
        if (temps!= null && temps.size()>0){
            myModel.put("reviews", temps);
        }
        return new ModelAndView("viewchallenge", "model", myModel);
    }


    public void setChallengeManager(ChallengeManager challengeManager) {
        this.challengeManager = challengeManager;
    }
    public void setReviewManager(ReviewManager reviewManager) {
        this.reviewManager = reviewManager;
    }

}
