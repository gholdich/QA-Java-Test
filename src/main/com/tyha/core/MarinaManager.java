package com.tyha.core;

import com.tyha.Program;
import com.tyha.objects.Marina;

public class MarinaManager {
	
	public Marina getMarinaByLocation(String location) {
		return Program.getInstance().getEntity().getMarinaList()
					.stream()
					.filter(e -> e.getAddress().contains(location))
					.findFirst()
					.orElse(null);
	}
	
}
