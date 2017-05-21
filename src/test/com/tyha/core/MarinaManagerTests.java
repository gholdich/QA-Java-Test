package com.tyha.core;

import static org.junit.Assert.assertEquals;

import org.junit.BeforeClass;
import org.junit.Test;

import com.tyha.Program;
import com.tyha.objects.Marina;

public class MarinaManagerTests {

	@BeforeClass
	public static void setUp() {
		new Program();
		Program.getInstance().init();
	}
	
	@Test
	public void testGetMarinaByLocation_checkObjectIsReturned_byStringOfMarinaLocation() {
		Marina marina = new Marina("Galaxy Harbour", "1827 port lane, salau, Spain", 350);
		Program.getInstance().getEntity().getMarinaList().add(marina);
		assertEquals(marina, Program.getInstance().getMarinaManager().getMarinaByLocation("salau"));
		Program.getInstance().getEntity().getMarinaList().remove(marina);
	}

}
