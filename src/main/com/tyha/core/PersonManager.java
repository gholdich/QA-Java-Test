package com.tyha.core;

import com.tyha.Program;
import com.tyha.objects.Person;

public class PersonManager {

	public Person getPersonByFullName(String firstName, String surname) {
		return Program.getInstance().getEntity().getPersonList()
					.stream()
					.filter(e -> e.getFirstName().equals(firstName) && e.getSurname().equals(surname))
					.findFirst()
					.orElse(null);
	}
	
}
