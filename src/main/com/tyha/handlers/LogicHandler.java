package com.tyha.handlers;

import com.tyha.Program;
import com.tyha.objects.Boat;
import com.tyha.objects.Marina;
import com.tyha.objects.Person;
import com.tyha.tools.GenerateStatistics;

public class LogicHandler {

	public void init() {
		run();
	}
	
	private void run() {
		importFile();
		assignEntityAssociations();
		dataAnalysis();
	}
	
	public void importFile() {
		getInstance().getFileManager().parseObjectsFromFile("stage_5_input.txt");
	}
	
	public void assignEntityAssociations() {
		Marina venice = getInstance().getMarinaManager().getMarinaByLocation("Venice");
		Marina monaco = getInstance().getMarinaManager().getMarinaByLocation("Monaco");
		
		Boat boatyMcBoatFace = getInstance().getBoatManager().getBoatByName("Boaty McBoatface");
		Boat santaMaria = getInstance().getBoatManager().getBoatByName("Santa Maria");
		Boat marysDream = getInstance().getBoatManager().getBoatByName("Marys Dream");
		Boat aquaholic = getInstance().getBoatManager().getBoatByName("Aquaholic");
		
		Person peterJackson = getInstance().getPersonManager().getPersonByFullName("Peter", "Jackson");
		Person emmaWatson = getInstance().getPersonManager().getPersonByFullName("Emma", "Watson");
		Person adele = getInstance().getPersonManager().getPersonByFullName("Adele", "");
		Person avrilLavigne = getInstance().getPersonManager().getPersonByFullName("Avril", "Lavigne");
		Person brainJohnson = getInstance().getPersonManager().getPersonByFullName("Brian", "Johnson");
		Person maryJones = getInstance().getPersonManager().getPersonByFullName("Mary", "Jones");
		Person linusTorvalds = getInstance().getPersonManager().getPersonByFullName("Linus", "Torvalds");
		Person billKnightley = getInstance().getPersonManager().getPersonByFullName("Bill", "Knightley");
		Person davidGreen = getInstance().getPersonManager().getPersonByFullName("David", "Green");
		
		boatyMcBoatFace.setCaptain(peterJackson);
		boatyMcBoatFace.addOwners(emmaWatson);
		boatyMcBoatFace.addCrew(adele, avrilLavigne, brainJohnson);

		santaMaria.addCrew(peterJackson);
		
		marysDream.addOwners(maryJones);
		
		aquaholic.setCaptain(linusTorvalds);
		aquaholic.addOwners(billKnightley, davidGreen);
		
		venice.moorBoat(aquaholic);
		monaco.moorBoat(marysDream);
		monaco.moorBoat(boatyMcBoatFace);
		venice.moorBoat(santaMaria);
	}
	
	public void dataAnalysis() {
		GenerateStatistics statistics = new GenerateStatistics();
		statistics.oldestPersonPerMarina();
		statistics.oldestPersonPerMooredBoat();
		statistics.numberOfMooredBoatsPerMarina();
		
		Boat boatyMcBoatFace = getInstance().getBoatManager().getBoatByName("Boaty McBoatface");
		Marina venice = getInstance().getMarinaManager().getMarinaByLocation("Venice");
		boatyMcBoatFace.moveTo(venice);
		
		statistics.numberOfMooredBoatsPerMarina();
		statistics.mapAllBoatsInAMarina();
		statistics.allPersonsCurrentlyInHarbourPerBoat();
	}
	
	
	private InstanceHandler getInstance() {
		return Program.getInstance();
	}
	
}
