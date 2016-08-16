package au.usyd.elec5619.service;

import java.util.List;

import org.hibernate.SessionFactory;
import org.hibernate.classic.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import au.usyd.elec5619.domain.ChallengeEntry;
import au.usyd.elec5619.domain.User;

@Service(value="challengeentryManager")
@Transactional
public class DatabaseChallengeEntryManager implements ChallengeEntryManager {

	private SessionFactory sessionFactory;
	
	@Autowired
	public void setSessionFactory(SessionFactory sf) {
		this.sessionFactory = sf;
	}
	

	public void addChallengeEntry(ChallengeEntry challengeentry) {
		this.sessionFactory.getCurrentSession().save(challengeentry);
		
	}

	public ChallengeEntry getChallengeEntryById(long id) {
		Session currentSession = this.sessionFactory.getCurrentSession();
		ChallengeEntry challengeentry = (ChallengeEntry) currentSession.get(ChallengeEntry.class, id);
		return challengeentry;
	}
	

	public void updateChallengeEntry(ChallengeEntry challengeentry) {
		Session currentSession = this.sessionFactory.getCurrentSession();
		currentSession.merge(challengeentry);
	}
	
	public void deleteChallengeEntry(long id) {
		Session currentSession = this.sessionFactory.getCurrentSession();
		ChallengeEntry challengeentry = (ChallengeEntry) currentSession.get(ChallengeEntry.class, id);
		currentSession.delete(challengeentry);
	}


	public List<ChallengeEntry> getChallengeEntries() {
		return this.sessionFactory.getCurrentSession().createQuery("FROM ChallengeEntry").list();
	}
	
	public String getAuthor(long id) {
		List<User> user = this.sessionFactory.getCurrentSession()
		.createQuery("FROM User where id=:i")
		.setParameter("i", id).list();
		return user.get(0).getUsername();
	}
	
	public List<ChallengeEntry> queryChallengeEntries(String field, String name) {
		List<ChallengeEntry> challengeentries = this.sessionFactory.getCurrentSession()
				.createQuery("FROM ChallengeEntry where field=:name")
				.setParameter("name", name).setParameter("field", field).list();
				
				return challengeentries;
	}
	
	public List<ChallengeEntry> userChallengeEntries(long id) {
		List<ChallengeEntry> challengeentries = this.sessionFactory.getCurrentSession()
				.createQuery("FROM ChallengeEntry where field=:name")
				.setParameter("name", id).setParameter("field", "UserId").list();
				
				return challengeentries;
	}
	

	
}
