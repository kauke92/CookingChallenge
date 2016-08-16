package au.usyd.elec5619.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.hibernate.Hibernate;
import org.hibernate.SQLQuery;
import org.hibernate.SessionFactory;
import org.hibernate.classic.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import au.usyd.elec5619.domain.Challenge;
import au.usyd.elec5619.domain.Review;


@Service(value="reviewManager")
@Transactional
public class DatabaseReviewManager implements ReviewManager {

	
	private SessionFactory sessionFactory;

	@Autowired
	public void setSessionFactory(SessionFactory sf) {
		this.sessionFactory = sf;
	}
	
	@Override
	public List<Review> getReviewByChallengeId(long challenge_id) {

		List<Review> listToDisplay = new ArrayList<Review>();
		List <Review> sublist = this.sessionFactory.getCurrentSession().createQuery("FROM Review").list();
		for(Review c: sublist){
			if(c.getIds()==challenge_id){
				listToDisplay.add(c);
			}			
		}
		return listToDisplay;
	}

	@Override
	public void addReview(Review review) {
		Date now = new Date();
		review.setDatecreated(now.toString());
		this.sessionFactory.getCurrentSession().save(review);		
	}

	@Override
	public Review getReviewById(long id) {
		Session currentSession = this.sessionFactory.getCurrentSession();
		Review review = (Review) currentSession.get(Review.class, id);
		return review;
	}

	@Override
	public void updateReview(Review review) {
		Session currentSession = this.sessionFactory.getCurrentSession();
		currentSession.merge(review);	
	}

	@Override
	public void deleteReview(long id) {
		Session currentSession = this.sessionFactory.getCurrentSession();
		Review review = (Review) currentSession.get(Review.class, id);
		currentSession.delete(review);
	}

	

	



}
