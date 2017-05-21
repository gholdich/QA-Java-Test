package com.tyha.core;

import static org.junit.Assert.*;

import org.junit.BeforeClass;
import org.junit.Test;

import com.tyha.Program;
import com.tyha.objects.Boat;

public class BoatManagerTests {

	@BeforeClass
	public static void setUp() {
		new Program();
		Program.getInstance().init();
	}
	
	@Test
	public void testGetBoatByName_checkObjectIsReturned_byStringOfBoatName() {
		Boat boat = new Boat("Monster Explorer", "USA", 3.4);
		Program.getInstance().getEntity().getBoatList().add(boat);
		assertEquals(boat, Program.getInstance().getBoatManager().getBoatByName("Monster Explorer"));
		Program.getInstance().getEntity().getBoatList().remove(boat);
	}

}
