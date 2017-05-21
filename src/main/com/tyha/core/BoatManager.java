package com.tyha.core;

import com.tyha.Program;
import com.tyha.objects.Boat;

public class BoatManager {

	public Boat getBoatByName(String name) {
		return Program.getInstance().getEntity().getBoatList()
					.stream()
					.filter(e -> e.getName().equals(name))
					.findFirst()
					.orElse(null);
	}
	
}
