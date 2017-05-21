package com.tyha.objects;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import org.hamcrest.collection.IsMapContaining;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class MarinaTests {
	static Marina marina;
	static Marina smallMarina;
	static Marina mediumMarina;
	static Marina newMarina;
	static Boat boat;
	static Boat boat1;
	static Boat boat2;
	static Person personOne;
	static Person personTwo;
	
	private final ByteArrayOutputStream outConsole = new ByteArrayOutputStream();
	
	@Before
	public void setUp() {
		marina = new Marina("Mars Luxury Harbour", "123 dock drive, Newcastle, United Kingdom", 50);
		smallMarina = new Marina("Small Harbour", "6 shrink road, York, United Kingdom", 5);
		mediumMarina = new Marina("Medium Harbour", "6 shrink road, York, United Kingdom", 35);
		newMarina = new Marina("Galaxy Harbour", "1827 port lane, salau, Spain", 350);
		boat = new Boat("HMS Storm", "United Kingdom", 7.7);
		boat1 = new Boat("Monster Explorer", "USA", 3.4);
		boat2 = new Boat("HMS Destoryer", "Great Britan", 5.7);
		personOne = new Person("bob", "riley", "01/01/1970", "British");
		personTwo = new Person("dave", "chester", "09/03/1982", "Spanish", "8723642/e");
		boat1.addCrew(personOne);
		boat2.addOwners(personTwo);
	}
	
	@Before
	public void setUpStreams() {
	    System.setOut(new PrintStream(outConsole));
	}
	
	@Test
	public void testMoorBoat_addingMultipleBoatsToMarina() {
		marina.moorBoat(boat1);
		marina.moorBoat(boat2);
		assertThat(marina.getMarina(), IsMapContaining.hasEntry(boat1, marina));
		assertThat(marina.getMarina(), IsMapContaining.hasEntry(boat2, marina));
	}
	
	@Test
	public void testUnmoorBoat_removingMultipleBoatsFromMarina() {
		marina.moorBoat(boat1);
		marina.moorBoat(boat2);
		marina.unmoorBoat(boat1);
		marina.unmoorBoat(boat2);
		assertTrue(marina.getMarina().isEmpty());
	}
	
	@Test
	public void testMoorBoat_handlingLogicNotToRequirementOrSize_noPersonAssociations() {
		marina.moorBoat(boat);
		assertEquals("Cannot moor Boat: HMS Storm as it has no owners or staff assicated.\n", outConsole.toString());
	}
	
	@Test
	public void testMoorBoat_handlingLogicNotToRequirementOrSize_noSpace() {
		smallMarina.moorBoat(boat2);
		assertEquals("Not enough space in marina to moor Boat: HMS Destoryer.\n", outConsole.toString());
	}
	
	@Test
	public void testMoorBoat_handlingLogicNotToRequirementOrSize_boatAlreadyInMarina() {
		boat.addOwners(personOne);
		mediumMarina.moorBoat(boat);
		newMarina.moorBoat(boat);
		assertEquals("The Boat: HMS Storm is already moored at Medium Harbour.\n", outConsole.toString());
	}
	
	@Test
	public void testGettersAndSetters() {
		testNameSetterAndGetter_setsNamePropertyAndGetsValue(marina);
		testAddressSetterAndGetter_setsAddressPropertyAndGetsValue(marina);
		testSizeSetterAndGetter_setsSizePropertyAndGetsValue(marina);
	}
	
	public void testNameSetterAndGetter_setsNamePropertyAndGetsValue(Marina marina) {
		String expected = "dummy_name";
		marina.setName(expected);
		String actual = marina.getName();
		assertEquals(expected, actual);
	}
	
	public void testAddressSetterAndGetter_setsAddressPropertyAndGetsValue(Marina marina) {
		String expected = "dummy_address";
		marina.setAddress(expected);
		String actual = marina.getAddress();
		assertEquals(expected, actual);
	}
	
	public void testSizeSetterAndGetter_setsSizePropertyAndGetsValue(Marina marina) {
		int expected = 65;
		marina.setMaxSpace(expected);
		int actual = marina.getMaxSpace();
		assertEquals(expected, actual);
	}
	
	@After
	public void cleanUpStreams() {
	    System.setOut(null);
	}
	
	@After
	public void tearDown() {
		marina.getMarina().clear();
		smallMarina.getMarina().clear();
		mediumMarina.getMarina().clear();
		newMarina.getMarina().clear();
		boat.getCrew().clear();
		boat.setCaptain(null);
		boat.getOwners().clear();
		boat.setMooredAt(null);
		boat1.getCrew().clear();
		boat1.setCaptain(null);
		boat1.getOwners().clear();
		boat1.setMooredAt(null);
		boat2.getCrew().clear();
		boat2.setCaptain(null);
		boat2.getOwners().clear();
		boat2.setMooredAt(null);
	}

}
