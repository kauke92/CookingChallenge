package au.usyd.elec5619.service;

import java.util.List;

import org.hibernate.SessionFactory;
import org.hibernate.classic.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import au.usyd.elec5619.domain.Submission;
import au.usyd.elec5619.domain.User;

@Service(value="submissionManager")
@Transactional
public class DatabaseSubmissionManager implements SubmissionManager {

	private SessionFactory sessionFactory;
	
	@Autowired
	public void setSessionFactory(SessionFactory sf) {
		this.sessionFactory = sf;
	}
	

	public void addSubmission(Submission submission) {
		this.sessionFactory.getCurrentSession().save(submission);
		
	}

	public Submission getSubmissionById(long id) {
		Session currentSession = this.sessionFactory.getCurrentSession();
		Submission submission = (Submission) currentSession.get(Submission.class, id);
		return submission;
	}
	

	public void updateSubmission(Submission submission) {
		Session currentSession = this.sessionFactory.getCurrentSession();
		currentSession.merge(submission);
	}
	
	public void deleteSubmission(long id) {
		Session currentSession = this.sessionFactory.getCurrentSession();
		Submission submission = (Submission) currentSession.get(Submission.class, id);
		currentSession.delete(submission);
	}


	public List<Submission> getSubmissions() {
		return this.sessionFactory.getCurrentSession().createQuery("FROM Submission").list();
	}
	
	public String getAuthor(long id) {
		List<User> user = this.sessionFactory.getCurrentSession()
		.createQuery("FROM User where id=:i")
		.setParameter("i", id).list();
		return user.get(0).getUsername();
	}
	
	public List<Submission> querySubmissions(String field, String name) {
		List<Submission> submissions = this.sessionFactory.getCurrentSession()
				.createQuery("FROM Submission where field=:name")
				.setParameter("name", name).setParameter("field", field).list();
				
				return submissions;
	}
	

	
}
