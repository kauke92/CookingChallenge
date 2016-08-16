package au.usyd.elec5619.service;

import java.util.List;

import au.usyd.elec5619.domain.Challenge;

public interface ChallengeManager {
	
	    
	    public List<Challenge> getChallenges();
	    
	    public void addChallenge(Challenge challenge);
	    
	    public Challenge getChallengeById(long id);
	    
	    public void updateChallenge(Challenge challenge);
	    
	    public void deleteChallenge(long id);
}
