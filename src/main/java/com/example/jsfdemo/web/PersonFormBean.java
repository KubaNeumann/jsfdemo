package com.example.jsfdemo.web;

import java.io.Serializable;
import java.util.List;

import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;

import com.example.jsfdemo.domain.Person;
import com.example.jsfdemo.service.PersonManager;

@SessionScoped
@Named("personBean")
public class PersonFormBean implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private Person person = new Person();
	
	@Inject
	private PersonManager pm;
	
	public Person getPerson() {
		return person;
	}
	public void setPerson(Person person) {
		this.person = person;
	}
	
	public List<Person> getAllPersons(){
		return pm.getAllPerson();
	}
	
	// Actions
	public String addPerson(){
		
		pm.addPerson(person);
		
		return "showPersons";
	}
}

