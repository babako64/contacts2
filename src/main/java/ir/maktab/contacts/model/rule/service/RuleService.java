package ir.maktab.contacts.model.rule.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ir.maktab.contacts.model.contact.Contact;
import ir.maktab.contacts.model.contact.dao.ContactDAOImpl;
import ir.maktab.contacts.model.rule.Rule;
import ir.maktab.contacts.model.rule.dao.RuleDAOImpl;

@Service
@Transactional(readOnly = true)
public class RuleService {

	@Autowired
	RuleDAOImpl ruleDAO;

	public List getAll() {

		return ruleDAO.getAll();

	}

	@Transactional
	public void insert(Rule r) {

		ruleDAO.add(r);
	}

	@Transactional
	public void update(long id, Rule r) {

		ruleDAO.update(id, r);
	}

	@Transactional
	public void delete(long id) {

		ruleDAO.delete(id);
	}
}
