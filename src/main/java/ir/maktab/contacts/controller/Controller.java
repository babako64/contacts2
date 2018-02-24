package ir.maktab.contacts.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import ir.maktab.contacts.model.contact.Contact;
import ir.maktab.contacts.model.contact.service.ContactService;
import ir.maktab.contacts.model.rule.Rule;
import ir.maktab.contacts.model.rule.service.RuleService;
import ir.maktab.contacts.model.user.User;
import ir.maktab.contacts.model.user.service.userService;

@org.springframework.stereotype.Controller
public class Controller {

	
	@Autowired
	private ContactService ContactService;
	
	@Autowired
	private RuleService ruleService;
	
	@Autowired
	private userService userServise;
	
	//-------------------------------------- contact -----------------------------------------------
	
	@RequestMapping(value = {"/contacts" }, method = RequestMethod.GET)
	public String getAllContacts(ModelMap model) {
		List<Contact> c = ContactService.getAll();
		System.out.println(c.get(0).getFirstName());;
		model.addAttribute("contacts", c);
		
        return "userslist";
	}
	
	 @RequestMapping(value = { "/newcontact" }, method = RequestMethod.GET)
	    public String newUser(ModelMap model) {
	        Contact contact = new Contact();
	        model.addAttribute("contact", contact);
	        model.addAttribute("edit", false);
	        return "registration";
	    }
	
	@RequestMapping(value = {"/newcontact" }, method = RequestMethod.POST)
	public String addContact(@Validated Contact contact , BindingResult result, ModelMap model) {
           
		  ContactService.insert(contact);
		  model.addAttribute("success", "Contact" + contact.getFirstName() + " "+ contact.getLastName() + " registered successfully");
		  return "registrationsuccess";
	}
	
	@RequestMapping(value = {"/contact/{id}" }, method = RequestMethod.PUT)
	public void updateContact(@PathVariable("id") long id,@RequestBody Contact c) {
		  ContactService.update(id, c);
	}
	@RequestMapping(value = {"/contact/{id}" }, method = RequestMethod.DELETE)
	public void removeContact(@PathVariable("id") long id) {
		  ContactService.delete(id);
	}
	
	//-------------------------------------- rule -----------------------------------------------
	
	@RequestMapping(value = {"/rules" }, method = RequestMethod.GET)
	public List getAllRule() {
		return ruleService.getAll();
	}
	@RequestMapping(value = "/rule", method = RequestMethod.POST, headers = "Accept=application/json")
	public void addRule(@RequestBody  Rule r) {
		ruleService.insert(r);
	     //return ResponseEntity.ok().body("New Book has been saved with ID:" + id);
	}
	
	@RequestMapping(value = {"/rule/{id}" }, method = RequestMethod.PUT)
	public void updateRule(@PathVariable("id") long id,@RequestBody Rule r) {
		ruleService.update(id, r);
	}
	@RequestMapping(value = {"/rule/{id}" }, method = RequestMethod.DELETE)
	public void removeRule(@PathVariable("id") long id) {
		ruleService.delete(id);
	}
	
	//--------------------------------------user -----------------------------------------------
	
	@RequestMapping(value = {"/users" }, method = RequestMethod.GET)
	public List getAllUser() {
		return userServise.getAll();
	}
	@RequestMapping(value = "/user/{id}", method = RequestMethod.POST, headers = "Accept=application/json")
	public void addUser(@RequestBody  User u, @PathVariable("id") long ruleID) {
		userServise.insert(ruleID, u);
	     //return ResponseEntity.ok().body("New Book has been saved with ID:" + id);
	}
	
	@RequestMapping(value = {"/user/{id}" }, method = RequestMethod.PUT)
	public void updateUser(@PathVariable("id") long id,@RequestBody User u) {
		userServise.update(id, u);
	}
	@RequestMapping(value = {"/user/{id}" }, method = RequestMethod.DELETE)
	public void removeUser(@PathVariable("id") long id) {
		userServise.delete(id);
	}
}
