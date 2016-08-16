package au.usyd.elec5619.service;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.SessionFactory;
import org.hibernate.classic.Session;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import au.usyd.elec5619.domain.Recipe;
import au.usyd.elec5619.domain.User;
import au.usyd.elec5619.domain.UserRole;

@Service(value="userManager")
@Transactional
public class DatabaseUserManager implements UserManager {

	private SessionFactory sessionFactory;
	
	@Autowired
	public void setSessionFactory(SessionFactory sf) {
		this.sessionFactory = sf;
	}
	
	public void addUser(User user) {
		this.sessionFactory.getCurrentSession().save(user);
//		this.sessionFactory.getCurrentSession().beginTransaction().commit();
//	
//		UserRole ur = new UserRole();
//		ur.setUserRoleId(123);
//		ur.setUser(user);
//		ur.setRole("ROLE_USER");
//		this.sessionFactory.getCurrentSession().save(ur);
		
	}

	@SuppressWarnings("unchecked")
	public User getUserByUsername(String username) {
		ArrayList<User> list = (ArrayList<User>) this.sessionFactory.getCurrentSession()
				.createQuery("from User where Username = :id").setParameter("id", username).list();
		if (list == null || list.size() == 0)
			return null;
		return list.get(0);
	}
	
	public User getUserById(long id) {
		Session currentSession = this.sessionFactory.getCurrentSession();
		User user = (User) currentSession.get(User.class, id);
		return user;
	}
	
	public boolean checkUsername(String username) {
		Session currentSession = this.sessionFactory.getCurrentSession();
		return currentSession
                .createQuery("from User where username=:name")
                .setParameter("name", username)
                .uniqueResult() != null;
	}

	public void updateUser(User user) {
		Session currentSession = this.sessionFactory.getCurrentSession();
		currentSession.saveOrUpdate(user);
	}
	
	public void deleteUser(long id) {
		Session currentSession = this.sessionFactory.getCurrentSession();
		User user = (User) currentSession.get(User.class, id);
		currentSession.delete(user);
	}

/*	public void increasePrice(int percentage) {
		Session currentSession = this.sessionFactory.getCurrentSession();
		List<User> users = currentSession.createQuery("FROM User").list();
		
		if (users != null) {
			for(User user : users) {
			//	double newPrice = user.getPrice().doubleValue()*(100+percentage)/100;
				//user.setPrice(newPrice);
				currentSession.save(user);
			}
		}
	}*/

	public List<User> getUsers() {
		return this.sessionFactory.getCurrentSession().createQuery("FROM User").list();
	}

	
	public List<User> searchUsers(String search, String field){
		String str = "%" + search + "%";
		return this.sessionFactory.getCurrentSession().createCriteria(User.class).
				add(Restrictions.like(field, str)).list();
	}
	
	
/*	public void storeUserImage(User user, byte[] file) {
		Session currentSession = this.sessionFactory.getCurrentSession();
		byte[] File = file;
		Blob image = Hibernate.getLobCreator(currentSession).createBlob(File);
		try {
			System.out.println(image.length());
		} catch (SQLException e) {
			
		}
		user.setProfileimagelocation(image);
		currentSession.merge(user);
	}*/
	
}