package ir.maktab.contacts.model.rule.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import ir.maktab.contacts.base.AbstractEntityDAO;
import ir.maktab.contacts.model.contact.Contact;
import ir.maktab.contacts.model.rule.Rule;

@Repository
public class RuleDAOImpl extends AbstractEntityDAO<Rule>{

	@Autowired
	private SessionFactory factory;
	
	@Override
	public void add(Rule e) {
		factory.getCurrentSession().save(e);
	}

	@Override
	public void update(long id, Rule e) {
		Session session = factory.getCurrentSession();
		session.update(e);
	}

	@Override
	public Rule getById(long id) {
		Session session = factory.getCurrentSession();
		Rule rule = (Rule) session.load(Rule.class, id);
		return rule;
	}

	@Override
	public boolean delete(long id) {
		
		Session session = factory.getCurrentSession();
		Rule rule = (Rule) session.load(Rule.class, id);
		if (null != rule) {
			session.delete(rule);
			return true;
		}
		return false;
	}

	@Override
	public List<Rule> getAll() {
		Session session = factory.getCurrentSession();

		List ruleList = session.createQuery("FROM Rule").list();

		return ruleList;
	}
	
}
