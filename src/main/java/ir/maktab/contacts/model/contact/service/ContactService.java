package ir.maktab.contacts.model.contact.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ir.maktab.contacts.model.contact.Contact;
import ir.maktab.contacts.model.contact.dao.ContactDAOImpl;

@Service
@Transactional(readOnly = true)
public class ContactService {

	@Autowired
	ContactDAOImpl contactDAO;

	public List<Contact> getAll() {

		return contactDAO.getAll();

	}

	@Transactional
	public void insert(Contact c) {

		contactDAO.add(c);
	}

	@Transactional
	public void update(long id, Contact c) {

		contactDAO.update(id, c);
		;
	}

	@Transactional
	public void delete(long id) {

		contactDAO.delete(id);
	}
}
