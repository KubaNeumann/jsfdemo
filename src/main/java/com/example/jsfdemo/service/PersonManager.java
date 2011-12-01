package com.example.jsfdemo.service;

import java.util.ArrayList;
import java.util.List;

import javax.enterprise.context.ApplicationScoped;

import com.example.jsfdemo.domain.Person;

@ApplicationScoped
public class PersonManager {
	private List<Person> db = new ArrayList<Person>();

	public void addPerson(Person person) {
		Person newPerson = new Person();
		newPerson.setName(person.getName());
		newPerson.setYob(person.getYob());
		db.add(newPerson);
	}

	// Removes the first person with given name and yob
	public void deletePerson(Person person) {

		Person personToRemove = null;

		for (Person p : db) {
			if (person.getName().equals(p.getName())
					&& person.getYob() == p.getYob()) {
				personToRemove = p;
				break;
			}
		}

		if (personToRemove != null)
			db.remove(personToRemove);
	}

	public List<Person> getAllPerson() {
		return db;
	}
}
