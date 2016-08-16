package au.usyd.elec5619.service;

import java.io.Serializable;
import java.util.List;

import au.usyd.elec5619.domain.Recipe;
import au.usyd.elec5619.domain.User;

public interface UserManager extends Serializable {
	
//	public void increasePrice(int percentage);
	
	public List<User> getUsers();
	
	public void addUser(User user);
	
	public User getUserById(long id);
	
	public User getUserByUsername(String username);
	
	public boolean checkUsername(String id);
	
	public void updateUser(User user);
	
	public void deleteUser(long id);
	
	public List<User> searchUsers(String search, String field);
	
	
	//public void storeUserImage(User userById, byte[] read);
}
