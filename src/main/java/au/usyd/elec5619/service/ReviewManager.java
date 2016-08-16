package au.usyd.elec5619.service;

import java.util.List;

import au.usyd.elec5619.domain.Review;

public interface ReviewManager {
    
    public List<Review> getReviewByChallengeId(long challenge_id);
    
    public void addReview(Review review);
    
    public Review getReviewById(long id);
    
    public void updateReview(Review review);
    
    public void deleteReview(long id);
}
