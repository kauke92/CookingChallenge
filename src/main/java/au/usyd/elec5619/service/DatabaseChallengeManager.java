package au.usyd.elec5619.service;

import java.util.List;

import org.hibernate.SessionFactory;
import org.hibernate.classic.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import au.usyd.elec5619.domain.Challenge;

@Service(value="challengeManager")
@Transactional
public class DatabaseChallengeManager implements ChallengeManager {


	private SessionFactory sessionFactory;

	@Autowired
	public void setSessionFactory(SessionFactory sf) {
		this.sessionFactory = sf;
	}

	

	@Override
	public List<Challenge> getChallenges() {
		return this.sessionFactory.getCurrentSession().createQuery("FROM Challenge").list();
	}

	@Override
	public void addChallenge(Challenge challenge) {
		this.sessionFactory.getCurrentSession().save(challenge);
	}

	@Override
	public Challenge getChallengeById(long id) {
		Session currentSession = this.sessionFactory.getCurrentSession();
		Challenge challenge = (Challenge) currentSession.get(Challenge.class, id);
		return challenge;
	}

	@Override
	public void updateChallenge(Challenge challenge) {
		Session currentSession = this.sessionFactory.getCurrentSession();
		currentSession.merge(challenge);
	}

	@Override
	public void deleteChallenge(long id) {
		Session currentSession = this.sessionFactory.getCurrentSession();
		Challenge challenge = (Challenge) currentSession.get(Challenge.class, id);
		currentSession.delete(challenge);
	}






}
