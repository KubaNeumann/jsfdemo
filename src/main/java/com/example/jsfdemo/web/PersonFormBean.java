package com.example.jsfdemo.web;

import java.io.Serializable;

import javax.enterprise.context.SessionScoped;
import javax.faces.model.ListDataModel;
import javax.inject.Inject;
import javax.inject.Named;

import com.example.jsfdemo.domain.Person;
import com.example.jsfdemo.service.PersonManager;

@SessionScoped
@Named("personBean")
public class PersonFormBean implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private Person person = new Person();
	
	private ListDataModel<Person> persons = new ListDataModel<Person>();
	
	@Inject
	private PersonManager pm;
	
	public Person getPerson() {
		return person;
	}
	public void setPerson(Person person) {
		this.person = person;
	}
	
	public ListDataModel<Person> getAllPersons(){
		persons.setWrappedData(pm.getAllPerson());
		return persons;
	}
	
	// Actions
	public String addPerson(){
		pm.addPerson(person);
		return "showPersons";
	}
	
	public String deletePerson(){
		Person personToDelete = persons.getRowData();
		pm.deletePerson(personToDelete);
		return null;
	}
}

