package com.tyha.handlers;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.BeforeClass;
import org.junit.Test;

import com.tyha.Program;
import com.tyha.objects.Boat;
import com.tyha.objects.Marina;
import com.tyha.objects.Person;

public class LogicHandlerTests {
	
	@BeforeClass
	public static void setUp() {
		new Program();
		Program.getInstance().init();
	}

	@Test
	public void testCreateObjectsFromFile_checkDataBeforeAndAfterToValidate() {
		assertTrue(Program.getInstance().getEntity().getMarinaList().isEmpty());
		assertTrue(Program.getInstance().getEntity().getBoatList().isEmpty());
		assertTrue(Program.getInstance().getEntity().getPersonList().isEmpty());
		Program.getLogic().importFile();
		assertFalse(Program.getInstance().getEntity().getMarinaList().isEmpty());
		assertFalse(Program.getInstance().getEntity().getBoatList().isEmpty());
		assertFalse(Program.getInstance().getEntity().getPersonList().isEmpty());
	}
	
	@Test
	public void testAssignEntityAssociations_validateDataBeforeAndAfter() {
		Marina monaco = Program.getInstance().getMarinaManager().getMarinaByLocation("Monaco");
		Boat boatyMcBoatFace = Program.getInstance().getBoatManager().getBoatByName("Boaty McBoatface");
		Person peterJackson = Program.getInstance().getPersonManager().getPersonByFullName("Peter", "Jackson");
		assertFalse(boatyMcBoatFace.personnelAssociated().contains(peterJackson));
		assertFalse(monaco.getMarina().containsKey(boatyMcBoatFace));
		Program.getLogic().assignEntityAssociations();
		assertTrue(boatyMcBoatFace.personnelAssociated().contains(peterJackson));
		assertTrue(monaco.getMarina().containsKey(boatyMcBoatFace));
	}

}
