package au.usyd.elec5619.web;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import au.usyd.elec5619.domain.Challenge;
import au.usyd.elec5619.domain.Review;
import au.usyd.elec5619.service.ChallengeManager;
import au.usyd.elec5619.service.ReviewManager;

@Controller
@RequestMapping(value="/submit/**")
public class ReviewController {
	@Resource(name="reviewManager")
	private ReviewManager reviewManager;
	
	@Resource(name="challengeManager")
	private ChallengeManager challengeManager;
	
	private Long global_id;
	
	
	@RequestMapping(value="/addreview/{id}", method=RequestMethod.GET)
	public String addReview(@PathVariable("id") Long id, Model uiModel) {
		
		Review review = new Review();
		review.setIds(id);
		uiModel.addAttribute("review", review);
		uiModel.addAttribute("challenge_id", id);
		global_id = id;
		return "addreview";
	}
	
	
	@RequestMapping(value="/addreview/**", method=RequestMethod.POST)
	public String addReview(Review review) {
		review.setIds(global_id);
		this.reviewManager.addReview(review);
		
		List <Review> temp = challengeManager.getChallengeById(review.getIds()).getReviews();
		if(temp == null){
			ArrayList <Review> temp2 = new ArrayList<Review>();
			temp2.add(review);
			challengeManager.getChallengeById(review.getIds()).setReviews(temp2);
			
		} else {
			
			temp.add(review);
			challengeManager.getChallengeById(review.getIds()).setReviews(temp);

		}
		
		return "redirect:/challenge";
	}

}
