package com.tyha.handlers;

import com.tyha.core.BoatManager;
import com.tyha.core.FileManager;
import com.tyha.core.MarinaManager;
import com.tyha.core.PersonManager;
import com.tyha.objects.Entitys;

public class InstanceHandler {
	private transient Entitys entitys;
	private transient FileManager fileManager;
	private transient MarinaManager marinaManager;
	private transient BoatManager boatManager;
	private transient PersonManager personManager;
	
	public void init() {
		entitys = new Entitys();
		fileManager = new FileManager();
		marinaManager = new MarinaManager();
		boatManager = new BoatManager();
		personManager = new PersonManager();
	}
	
	public Entitys getEntity() {
		return entitys;
	}
	
	public FileManager getFileManager() {
		return fileManager;
	}

	public MarinaManager getMarinaManager() {
		return marinaManager;
	}
	
	public BoatManager getBoatManager() {
		return boatManager;
	}

	public PersonManager getPersonManager() {
		return personManager;
	}
	
}
