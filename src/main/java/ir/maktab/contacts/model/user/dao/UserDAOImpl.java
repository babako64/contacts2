package ir.maktab.contacts.model.user.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import ir.maktab.contacts.base.AbstractEntityDAO;
import ir.maktab.contacts.model.contact.Contact;
import ir.maktab.contacts.model.rule.Rule;
import ir.maktab.contacts.model.user.User;

@Repository
public class UserDAOImpl extends AbstractEntityDAO<User>{

	
	@Autowired
	private SessionFactory factory;
	
	
	public void add(long ruleID, User user) {
		
		Rule rule = (Rule) factory.getCurrentSession().load(Rule.class, ruleID);
		user.setUserRule(rule);
		factory.getCurrentSession().save(user);
	}

	@Override
	public void update(long id, User e) {
		Session session = factory.getCurrentSession();
		session.update(e);
	}

	@Override
	public User getById(long id) {
		Session session = factory.getCurrentSession();
		User user = (User) session.load(User.class, id);
		return user;
	}

	@Override
	public boolean delete(long id) {
		Session session = factory.getCurrentSession();
		User user = (User) session.load(User.class, id);
		if (null != user) {
			session.delete(user);
			return true;
		}
		return false;
	}

	@Override
	public List<User> getAll() {
		Session session = factory.getCurrentSession();

		List userList = session.createQuery("FROM User").list();

		return userList;
	}

	
}
