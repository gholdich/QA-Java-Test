package com.tyha.core;

import static org.junit.Assert.*;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import com.tyha.Program;

public class FileManagerTests {
	private final ByteArrayOutputStream errConsole = new ByteArrayOutputStream();
	
	@BeforeClass
	public static void setUp() {
		new Program();
		Program.getInstance().init();
	}

	@Before
	public void setUpStreams() {
	    System.setErr(new PrintStream(errConsole));
	}

	@Test
	public void testParseObjectsFromFile_checkFunctionality_HandleException() {
		assertTrue(Program.getInstance().getEntity().getMarinaList().isEmpty());
		assertTrue(Program.getInstance().getEntity().getBoatList().isEmpty());
		assertTrue(Program.getInstance().getEntity().getPersonList().isEmpty());
		Program.getInstance().getFileManager().parseObjectsFromFile("stage_5_input.txt");
		assertFalse(Program.getInstance().getEntity().getMarinaList().isEmpty());
		assertFalse(Program.getInstance().getEntity().getBoatList().isEmpty());
		assertFalse(Program.getInstance().getEntity().getPersonList().isEmpty());
		
		//Check for Exception when file does not exist.
		Program.getInstance().getFileManager().parseObjectsFromFile("stage_5_input.tt");
		assertEquals("File: stage_5_input.tt cannot be located on the filesystem.\n", errConsole.toString());
	}
	
	@After
	public void cleanUpStreams() {
	    System.setErr(null);
	}

}
