package com.tyha.objects;

import static org.junit.Assert.*;

import org.junit.BeforeClass;
import org.junit.Test;

public class EntitysTests {
	static Entitys entitys;
	static Marina marina;
	static Boat boat;
	static Person person;
	
	@BeforeClass
	public static void setUp() {
		entitys = new Entitys();
		marina = new Marina("Mars Luxury Harbour", "123 dock drive, Newcastle, United Kingdom", 50);
		boat = new Boat("Monster Explorer", "USA", 3.4);
		person = new Person("bob", "riley", "01/01/1970", "British");
	}

	@Test
	public void testMarinaList_getter_validateAddingOfData() {
		entitys.getMarinaList().add(marina);
		assertTrue(entitys.getMarinaList().contains(marina));
	}
	
	@Test
	public void testBoatList_getter_validateAddingOfData() {
		entitys.getBoatList().add(boat);
		assertTrue(entitys.getBoatList().contains(boat));
	}
	
	@Test
	public void testPersonList_getter_validateAddingOfData() {
		entitys.getPersonList().add(person);
		assertTrue(entitys.getPersonList().contains(person));
	}

}
