package au.usyd.elec5619.service;

import java.util.List;

import org.hibernate.SessionFactory;
import org.hibernate.classic.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import au.usyd.elec5619.domain.Guide;

@Service(value="guideManager")
@Transactional
public class DatabaseGuideManager implements GuideManager {
	private SessionFactory sessionFactory;
	
	@Autowired
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<Guide> getGuides() {
		return this.sessionFactory.getCurrentSession().createQuery("FROM Guide").list();
	}
	
	@Override
	public void addGuide(Guide guide) {
		this.sessionFactory.getCurrentSession().save(guide);
	}

	@Override
	public Guide getGuideById(long id) {
		Session currentSession = this.sessionFactory.getCurrentSession();
		return (Guide) currentSession.get(Guide.class, id);
	}

	@Override
	public void updateGuide(Guide guide) {
		Session currentSession = this.sessionFactory.getCurrentSession();
		currentSession.merge(guide);
		
	}

	@Override
	public void deleteGuide(long id) {
		Session currentSession = this.sessionFactory.getCurrentSession();
		currentSession.delete((Guide) currentSession.get(Guide.class, id));
		
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Guide> getGuidesByCategoryId(long id) {
		return this.sessionFactory.getCurrentSession().createQuery("from Guide where guideCategory = :username")
				.setParameter("username", id).list();
	}
}
