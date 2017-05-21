package com.tyha.objects;

import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.Collection;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

@RunWith(Parameterized.class)
public class PersonTests {
	
	private Person p;
	
	public PersonTests(Person person) {
		this.p = person;
	}
	
	@Parameters
	public static Collection<Person[]> parameters() {
		Person[][] persons = {{new Person("bob", "riley", "01/01/1970", "British")}, 
							{new Person("dave", "chester", "09/03/1982", "Spanish", "8723642/e")}};
		return Arrays.asList(persons);
	}
	
	@Test
	public void testFristNameSetterAndGetter_setsFirstNamePropertyAndGetsValue() {
		String expected = "dummy_firstname";
		p.setFirstName(expected);
		String actual = p.getFirstName();
		assertEquals(expected, actual);
	}
	
	@Test
	public void testSurnameSetterAndGetter_setsSurnamePropertyAndGetsValue() {
		String expected = "dummy_surname";
		p.setSurname(expected);
		String actual = p.getSurname();
		assertEquals(expected, actual);
	}
	
	@Test
	public void testDoBSetterAndGetter_setsDoBPropertyAndGetsValue() {
		String expected = "16/02/1891";
		p.setDateOfBirth(expected);
		String actual = p.getDateOfBirth();
		assertEquals(expected, actual);
	}
	
	@Test
	public void testNationalitySetterAndGetter_setsNationalityPropertyAndGetsValue() {
		String expected = "dummy_nationality";
		p.setNationality(expected);
		String actual = p.getNationality();
		assertEquals(expected, actual);
	}
	
	@Test
	public void testVisaInfomationSetterAndGetter_setsVisaInfomationPropertyAndGetsValue() {
		String expected = "dummy_visa_information";
		p.setVisaInformation(expected);
		String actual = p.getVisaInformation();
		assertEquals(expected, actual);
	}

}
