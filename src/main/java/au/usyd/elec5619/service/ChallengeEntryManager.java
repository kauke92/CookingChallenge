package au.usyd.elec5619.service;

import java.io.Serializable;
import java.util.List;

import au.usyd.elec5619.domain.ChallengeEntry;

public interface ChallengeEntryManager extends Serializable {
		
	public List<ChallengeEntry> getChallengeEntries();
	
	public void addChallengeEntry(ChallengeEntry challengeentry);
	
	public ChallengeEntry getChallengeEntryById(long id);
	
	public void updateChallengeEntry(ChallengeEntry challengeentry);
	
	public void deleteChallengeEntry(long id);
	
	public String getAuthor(long id);
	
	public List<ChallengeEntry> queryChallengeEntries(String field, String name);
	
	public List<ChallengeEntry> userChallengeEntries(long id);
	//public void storeUserImage(User userById, byte[] read);
}
