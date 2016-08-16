package au.usyd.elec5619.service;

import java.util.ArrayList;
import java.util.List;

import junit.framework.TestCase;
import au.usyd.elec5619.domain.User;

public class SimpleUserManagerTest extends TestCase {

	private SimpleUserManager userManager;
	private List<User> users;
	
	private static int USER_COUNT = 2;
	
//	private static Double STEPHEN_PRICE = new Double(20.50);
	private static String STEPHEN_DESCRIPTION = "Stephen is here";
	private static String STEPHEN_USERNAME = "StephenM";
	private static String STEPHEN_PASSWORD = "12345";
	private static String STEPHEN_FIRSTNAME = "Stephen";
	private static String STEPHEN_LASTNAME = "McC";
	
//	private static Double JASON_PRICE = new Double(20.50);
	private static String JASON_DESCRIPTION = "Jason was here";
	private static String JASON_USERNAME = "JasonR";
	private static String JASON_PASSWORD = "trreiutor";
	private static String JASON_FIRSTNAME = "Jason";
	private static String JASON_LASTNAME = "Roo";
	
//	private static int POSITIVE_PRICE_INCREASE = 10;
	
	
	protected void setUp() throws Exception {
		userManager = new SimpleUserManager();
		users = new ArrayList<User>();
		
		//stub up a list of users
		User user = new User();
		user.setDescription("Stephen is here");
//		user.setPrice(STEPHEN_PRICE);
		user.setUsername(STEPHEN_USERNAME);
		user.setPassword(STEPHEN_PASSWORD);
		user.setFirstname(STEPHEN_FIRSTNAME);
		user.setLastname(STEPHEN_LASTNAME);
		users.add(user);
		
		user = new User();
		user.setDescription("Jason was here");
	//	user.setPrice(JASON_PRICE);
		user.setUsername(JASON_USERNAME);
		user.setPassword(JASON_PASSWORD);
		user.setFirstname(JASON_FIRSTNAME);
		user.setLastname(JASON_LASTNAME);
		users.add(user);
		
		userManager.setUsers(users);
		
		
		
	}
	
	public void testGetUsersWithNoUsers() {
		userManager = new SimpleUserManager();
		assertNull(userManager.getUsers());
	}

	public void testGetUsers() {
		List<User> users = userManager.getUsers();
		assertNotNull(users);
		assertEquals(USER_COUNT, userManager.getUsers().size());
		
		User user = users.get(0);
		assertEquals(STEPHEN_DESCRIPTION, user.getDescription());
	//	assertEquals(STEPHEN_PRICE, user.getPrice());
		assertEquals(STEPHEN_USERNAME, user.getUsername());
		assertEquals(STEPHEN_PASSWORD, user.getPassword());
		assertEquals(STEPHEN_FIRSTNAME, user.getFirstname());
		assertEquals(STEPHEN_LASTNAME, user.getLastname());
		
		
		
		user = users.get(1);
		assertEquals(JASON_DESCRIPTION, user.getDescription());
//		assertEquals(JASON_PRICE, user.getPrice());
		assertEquals(JASON_USERNAME, user.getUsername());
		assertEquals(JASON_PASSWORD, user.getPassword());
		assertEquals(JASON_FIRSTNAME, user.getFirstname());
		assertEquals(JASON_LASTNAME, user.getLastname());
	}
	
/*	public void testIncreasePriceWithNullListOfUsers() {
		try {
			userManager = new SimpleUserManager();
			userManager.increasePrice(POSITIVE_PRICE_INCREASE);
		}
		catch(NullPointerException ex) {
			fail("Users list is null.");

		}
	}

	public void testIncreasePriceWithEmptyListOfUsers() {
		try {
			userManager = new SimpleUserManager();
			userManager.setUsers(new ArrayList<User>());
			userManager.increasePrice(POSITIVE_PRICE_INCREASE);
		}
		catch(NullPointerException ex) {
			fail("Users list is empty.");

		}
	}
	
	public void testIncreasePriceWithPositivePercentage() {
		userManager.increasePrice(POSITIVE_PRICE_INCREASE);
		double expectedChairPriceWithIncrease = 22.55;
		double expectedTablePriceWithIncrease = 165.11;
		
		List<User> users = userManager.getUsers();
		User user = users.get(0);
	//	assertEquals(expectedChairPriceWithIncrease, user.getPrice());
		
		user = users.get(1);
		assertEquals(expectedTablePriceWithIncrease, user.getPrice());
	}*/
}