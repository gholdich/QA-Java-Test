package com.tyha.objects;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

import com.tyha.Program;

public class BoatTests {
	
	Marina marina;
	Boat boat;
	Person personOne;
	Person personTwo;
	
	@Before
	public void setUp() {
		marina = new Marina("Mars Luxury Harbour", "123 dock drive, Newcastle, United Kingdom", 50);
		boat = new Boat("Monster Explorer", "USA", 3.4);
		personOne = new Person("bob", "riley", "01/01/1970", "British");
		personTwo = new Person("dave", "chester", "09/03/1982", "Spanish", "8723642/e");
	}
	
	@Test
	public void testMooredAtSetterAndGetter_setsMooredAtPropertyAndGetsValue() {
		boat.setMooredAt(marina);
		assertEquals(marina, boat.getMooredAt());
	}
	
	@Test
	public void testCaptainSetterAndGetter_setsCaptainPropertyAndGetsValue() {
		boat.setCaptain(personOne);
		assertEquals(personOne, boat.getCaptain());
	}
	
	@Test
	public void testCrewList_getter_validateAddingOfData() {
		boat.addCrew(personOne, personTwo);
		assertTrue(boat.getCrew().containsAll(Stream.of(personOne, personTwo).collect(Collectors.toList())));
	}
	
	@Test
	public void testCrewList_getter_validateHandlingOfAddingCaptain() {
		boat.setCaptain(personOne);
		boat.addCrew(personOne, personTwo);
		assertEquals(boat.getCrew(), Stream.of(personTwo).collect(Collectors.toList()));
	}
	
	@Test
	public void testOwnersList_getter_validateAddingOfData() {
		boat.addOwners(personOne, personTwo);
		assertTrue(boat.getOwners().containsAll(Stream.of(personOne, personTwo).collect(Collectors.toList())));
	}
	
	@Test
	public void testPersonnelAssociatedList_addAllPersonsThatAreAssociatedWithBoat() {
		List<Person> expected_PersonnelAssociated = Arrays.asList(personOne, personTwo);
		List<Person> expected_PersonnelAssociated_reversed = Arrays.asList(personTwo, personOne);
		boat.addOwners(personOne, personTwo);
		boat.setCaptain(personOne);
		boat.addCrew(personTwo);
		assertEquals(expected_PersonnelAssociated, boat.personnelAssociated());
		assertEquals(expected_PersonnelAssociated_reversed, boat.personnelAssociated());
	}
	
	@Test
	public void testSpeed_getter_validateAccelerateAndDeccelerate() {
		int knots = boat.getSpeed();
		int expected = ++knots;
		boat.accelerate();
		assertEquals(expected, boat.getSpeed());
		expected = --knots;
		boat.deccelerate();
		assertEquals(expected, boat.getSpeed());
	}
	
	@Test
	public void testMoveBoat_validateUnmooringAndMooringOfBoatToNewMarina() {
		new Program();
		Program.getInstance().init();
		Marina newMarina = new Marina("Galaxy Harbour", "1827 port lane, salau, Spain", 350);
		Program.getInstance().getEntity().getMarinaList().add(marina);
		Program.getInstance().getEntity().getMarinaList().add(newMarina);
		boat.setMooredAt(marina);
		boat.addCrew(personOne);
		boat.moveTo(newMarina);
		assertEquals(newMarina, boat.getMooredAt());
	}
	

    @RunWith(Parameterized.class)
    public static class BoatParamTests {
    	
    	private Boat boat;
    	
    	public BoatParamTests(Boat boat) {
    		this.boat = boat;
    	}
    	
    	@Parameters
    	public static Collection<Boat[]> parameters() {
    		Boat[][] boats = {{new Boat("Monster Explorer", "USA", 3.4)}, 
    						{new Boat("HMS Destoryer", "Great Britan", 5.7)}};
    		return Arrays.asList(boats);
    	}

    	@Test
    	public void testNameSetterAndGetter_setsNamePropertyAndGetsValue() {
    		String expected = "dummy_name";
    		boat.setName(expected);
    		assertEquals(expected, boat.getName());
    	}
    	
    	@Test
    	public void testCountryOfOriginSetterAndGetter_setsCountryOfOriginPropertyAndGetsValue() {
    		String expected = "dummy_countryOfOrigin";
    		boat.setCountryOfOrigin(expected);
    		assertEquals(expected, boat.getCountryOfOrigin());
    	}
    	
    	@Test
    	public void testSizeSetterAndGetter_setsSizePropertyAndGetsValue() {
    		double expected = 4.3;
    		boat.setSize(expected);
    		assertTrue(expected == boat.getSize());
    	}
    	
    }
    
	@After
	public void tearDown() {
		marina.getMarina().clear();
		boat.setCaptain(null);
		boat.getCrew().clear();
		boat.getOwners().clear();
		boat.setMooredAt(null);
		Stream.empty();
	}

}
