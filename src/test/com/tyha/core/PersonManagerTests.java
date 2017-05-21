package com.tyha.core;

import static org.junit.Assert.assertEquals;

import org.junit.BeforeClass;
import org.junit.Test;

import com.tyha.Program;
import com.tyha.objects.Person;

public class PersonManagerTests {

	@BeforeClass
	public static void setUp() {
		new Program();
		Program.getInstance().init();
	}
	
	@Test
	public void testGetPersonByFullName_checkObjectIsReturned_byStringOfPersonFullName() {
		Person person = new Person("bob", "riley", "01/01/1970", "British");
		Program.getInstance().getEntity().getPersonList().add(person);
		assertEquals(person, Program.getInstance().getPersonManager().getPersonByFullName("bob", "riley"));
		Program.getInstance().getEntity().getPersonList().remove(person);
	}

}
