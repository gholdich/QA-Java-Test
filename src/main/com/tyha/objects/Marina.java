package com.tyha.objects;

import java.util.HashMap;
import java.util.Map;

public class Marina {
	
	private String name;
	private String address;
	private int maxSpace;
	private int spacesRemaining;
	Map<Boat, Marina> marina = new HashMap<>();

	public Marina(String name, String address, int maxSpace) {
		this.name = name;
		this.address = address;
		this.maxSpace = maxSpace;
		this.setSpacesRemaining(maxSpace);
	}
	
	public void moorBoat(Boat boat) {
		int spaces = getSpacesRemaining();
		
		if(boat.getMooredAt() != null) {
			System.out.println("The Boat: "+boat.getName()+" is already moored at "+boat.getMooredAt().getName()+".");
			return;
		}
			
		if(boat.getOwners().isEmpty() && boat.getCrew().isEmpty() && boat.getCaptain() == null) {
			System.out.println("Cannot moor Boat: "+boat.getName()+" as it has no owners or staff assicated.");
			return;
		}
			
		if(spaces - boat.getSize() < 0) {
			System.out.println("Not enough space in marina to moor Boat: "+boat.getName()+".");
			return;
		}
		
		getMarina().put(boat, this);
		boat.setMooredAt(this);
		setSpacesRemaining(spaces-((int)Math.ceil(boat.getSize())));
	}
	
	public void unmoorBoat(Boat boat) {
		if(boat.getMooredAt() == null) {
			System.out.println("The Boat: "+boat.getName()+" is not currently moored at any marina.");
			return;
		}
		
		getMarina().remove(boat, this);
		boat.setMooredAt(null);
		setSpacesRemaining(getSpacesRemaining()+((int)Math.ceil(boat.getSize())));
	}

	public String getName() {
		return name;
	}

	public String getAddress() {
		return address;
	}
	
	public int getMaxSpace() {
		return maxSpace;
	}
	
	public int getSpacesRemaining() {
		return spacesRemaining;
	}

	public Map<Boat, Marina> getMarina() {
		return marina;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setAddress(String address) {
		this.address = address;
	}
	
	public void setMaxSpace(int maxSpace) {
		this.maxSpace = maxSpace;
	}
	
	public void setSpacesRemaining(int spacesRemaining) {
		this.spacesRemaining = spacesRemaining;
	}
	
	
	
	
}
