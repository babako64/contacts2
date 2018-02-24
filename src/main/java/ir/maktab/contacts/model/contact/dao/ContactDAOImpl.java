package ir.maktab.contacts.model.contact.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import ir.maktab.contacts.base.AbstractEntityDAO;
import ir.maktab.contacts.model.contact.Contact;


@Repository
public class ContactDAOImpl extends AbstractEntityDAO<Contact> {

	@Autowired
	private SessionFactory factory;

	@Override
	public void add(Contact contact) {

		factory.openSession().save(contact);

	}

	@Override
	public void update(long id, Contact e) {
		Session session = factory.openSession();
		session.update(e);

	}

	@Override
	public Contact getById(long id) {
		Session session = factory.openSession();
		Contact contact = (Contact) session.load(Contact.class, id);
		return contact;
	}

	@Override
	public boolean delete(long id) {
		Session session = factory.openSession();
		Contact contact = (Contact) session.load(Contact.class, id);
		if (null != contact) {
			session.delete(contact);
			return true;
		}
		return false;
	}

	@Override
	public List<Contact> getAll() {

		Session session = factory.openSession();

		List<Contact> authorList = session.createQuery("FROM Contact").list();

		return authorList;
	}

}
