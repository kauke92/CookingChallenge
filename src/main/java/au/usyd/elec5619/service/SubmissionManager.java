package au.usyd.elec5619.service;

import java.io.Serializable;
import java.util.List;

import au.usyd.elec5619.domain.Submission;

public interface SubmissionManager extends Serializable {
		
	public List<Submission> getSubmissions();
	
	public void addSubmission(Submission submission);
	
	public Submission getSubmissionById(long id);
	
	public void updateSubmission(Submission submission);
	
	public void deleteSubmission(long id);
	
	public String getAuthor(long id);
	
	public List<Submission> querySubmissions(String field, String name);
	
	//public void storeUserImage(User userById, byte[] read);
}
