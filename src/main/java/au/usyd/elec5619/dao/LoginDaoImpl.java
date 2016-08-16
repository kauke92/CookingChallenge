package au.usyd.elec5619.dao;

import java.util.ArrayList;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import au.usyd.elec5619.domain.User;

@Transactional
@Repository("loginDao")
public class LoginDaoImpl implements LoginDao {

	@Autowired
	SessionFactory sessionFactory;

	Session session = null;
	Transaction tx = null;

	@SuppressWarnings("unchecked")
	@Override
	public User findByUserName(String username) {
		session = sessionFactory.openSession();
		tx = session.getTransaction();
		session.beginTransaction();
		ArrayList<User> list = (ArrayList<User>) this.sessionFactory.getCurrentSession()
				.createQuery("from User where Username = :id").setParameter("id", username).list();

		if (list == null || list.size() == 0)
			return null;
		return list.get(0);
	}

}
