package ir.maktab.contacts.model.user.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ir.maktab.contacts.model.contact.Contact;
import ir.maktab.contacts.model.contact.dao.ContactDAOImpl;
import ir.maktab.contacts.model.user.User;
import ir.maktab.contacts.model.user.dao.UserDAOImpl;

@Service
@Transactional(readOnly = true)
public class userService {

	@Autowired
	UserDAOImpl userDAO;

	public List getAll() {

		return userDAO.getAll();

	}

	@Transactional
	public void insert(long ruleID, User u) {

		userDAO.add(ruleID, u);
	}

	@Transactional
	public void update(long id, User u) {

		userDAO.update(id, u);
		;
	}

	@Transactional
	public void delete(long id) {

		userDAO.delete(id);
	}
}
