package com.tyha.objects;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import com.tyha.Program;
import com.tyha.interfaces.Vehicle;

public class Boat implements Vehicle  {
	
	private String name;
	private String countryOfOrigin;
	private double size;
	private ArrayList<Person> owners = new ArrayList<Person>();
	private ArrayList<Person> crew = new ArrayList<Person>();
	private Person captain;
	private Marina mooredAt;
	private int knots = 0;
	
	public Boat(String name, String countryOfOrigin, double size) {
		this.name = name;
		this.countryOfOrigin = countryOfOrigin;
		this.size = size;
	}
	
	public void addCrew(Person ...crew) {
		List<Person> crewList = new ArrayList<Person>(Arrays.asList(crew));
		if(crewList.contains(getCaptain())) {
			crewList.remove(getCaptain());
			crew = (Person[]) crewList.toArray(new Person[crewList.size()]);
			System.out.println(getCaptain().getFirstName()+" "+getCaptain().getSurname()+" was not assgined to crew beacuse they are already Captain.");
		}
		this.crew.addAll(Arrays.asList(crew));
	}
	
	public void addOwners(Person ...owners) {
		this.owners.addAll(Arrays.asList(owners));
	}
	
	public List<Person> personnelAssociated() {
		Set<Person> personnel = new HashSet<Person>();
			getOwners().stream().forEach(e -> personnel.add(e));
			personnel.add(getCaptain());
			getCrew().stream().forEach(e -> personnel.add(e));
			personnel.remove(null);
		return new ArrayList<Person>(personnel);
	}
	
	public void moveTo(Marina marina) {
		Marina from = getMooredAt();
		
		if(from != null)
			Program.getInstance().getMarinaManager().getMarinaByLocation(from.getAddress()).unmoorBoat(this);
		
		Program.getInstance().getMarinaManager().getMarinaByLocation(marina.getAddress()).moorBoat(this);
		System.out.println("The Boat: "
					+this.getName()
					+" has been moved"
					+(from != null ?" from "+from.getName() : "")
					+" to "+marina.getName());
	}
	
	@Override
	public int getSpeed() {
		return this.knots;
	}
	
	@Override
	public void accelerate() {
		++this.knots;
	}
	
	@Override
	public void deccelerate() {
		--this.knots;
	}
	
	public String getName() {
		return name;
	}
	public String getCountryOfOrigin() {
		return countryOfOrigin;
	}
	public double getSize() {
		return size;
	}
	public ArrayList<Person> getOwners() {
		return owners;
	}
	public ArrayList<Person> getCrew() {
		return crew;
	}
	public Person getCaptain() {
		return captain;
	}
	public Marina getMooredAt() {
		return mooredAt;
	}
	public void setName(String name) {
		this.name = name;
	}
	public void setCountryOfOrigin(String countryOfOrigin) {
		this.countryOfOrigin = countryOfOrigin;
	}
	public void setSize(double size) {
		this.size = size;
	}
	public void setCaptain(Person captain) {
		this.captain = captain;
	}
	public void setMooredAt(Marina marina) {
		this.mooredAt = marina;
	}

}
