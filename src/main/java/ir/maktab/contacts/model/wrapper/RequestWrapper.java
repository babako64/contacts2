package ir.maktab.contacts.model.wrapper;

import ir.maktab.contacts.model.contact.Contact;
import ir.maktab.contacts.model.rule.Rule;
import ir.maktab.contacts.model.user.User;

public class RequestWrapper {

	User user;
	
	Rule rule;

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Rule getRule() {
		return rule;
	}

	public void setRule(Rule rule) {
		this.rule = rule;
	}
	
	
	
	
}
