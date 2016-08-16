package au.usyd.elec5619.domain;

import junit.framework.TestCase;

public class UserTest extends TestCase{

	private User user;
	
	
	
	
	
	protected void setUp() throws Exception {
		user = new User();
	}
	
	public void testSetAndGetDescription() {
		String testDescription = "aDescription";
		
		assertNull(user.getDescription());
		user.setDescription(testDescription);
		assertEquals(testDescription, user.getDescription());
	}
	
/*	public void testSetAndGetPrice() {
		double testPrice = 100.00;
		assertEquals(0, 0, 0);
		user.setPrice(testPrice);
		assertEquals(testPrice, user.getPrice(), 0);
	}
	*/
	public void testSetAndGetUsername() {
		String testUsername= "aUsername";
		
		assertNull(user.getUsername());
		user.setUsername(testUsername);
		assertEquals(testUsername, user.getUsername());
	}
	
	public void testSetAndGetPassword() {
		String testPassword= "aPassword";
		
		assertNull(user.getPassword());
		user.setPassword(testPassword);
		assertEquals(testPassword, user.getPassword());
	}
	
	public void testSetAndGetConfirmpassword() {
		String testConfirmpassword= "aConfirmpassword";
		
		assertNull(user.getConfirmpassword());
		user.setConfirmpassword(testConfirmpassword);
		assertEquals(testConfirmpassword, user.getConfirmpassword());
	}
	
	public void testSetAndGetFirstname() {
		String testFirstname= "aFirstname";
		
		assertNull(user.getFirstname());
		user.setFirstname(testFirstname);
		assertEquals(testFirstname, user.getFirstname());
	}
	
	public void testSetAndGetLastname() {
		String testLastname= "aLastname";
		
		assertNull(user.getLastname());
		user.setLastname(testLastname);
		assertEquals(testLastname, user.getLastname());
	}
	
	public void testSetAndGetEmailaddress() {
		String testEmailaddress= "aEmailaddress";
		assertNull(user.getEmailaddress());
		user.setEmailaddress(testEmailaddress);
		assertEquals(testEmailaddress, user.getEmailaddress());
	}
	
	public void testSetAndGetLastname() {
		String testLastname= "aLastname";
		
		assertNull(user.getLastname());
		user.setLastname(testLastname);
		assertEquals(testLastname, user.getLastname());
	}
	
	public void testSetAndGetLastname() {
		String testLastname= "aLastname";
		
		assertNull(user.getLastname());
		user.setLastname(testLastname);
		assertEquals(testLastname, user.getLastname());
	}
	
	public void testSetAndGetLastname() {
		String testLastname= "aLastname";
		
		assertNull(user.getLastname());
		user.setLastname(testLastname);
		assertEquals(testLastname, user.getLastname());
	}
	
	
	
}