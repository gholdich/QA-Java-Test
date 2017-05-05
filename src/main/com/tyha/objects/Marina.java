package main.com.tyha.objects;

import java.util.HashMap;
import java.util.Map;

public class Marina {
	
	private int maxSpace;
	private String name;
	private String address;
	Map<Boat, Person> marina = new HashMap<>();

	public Marina(int maxSpace, String name, String address) {
		this.maxSpace = maxSpace;
		this.name = name;
		this.address = address;
	}


	public int getMaxSpace() {
		return maxSpace;
	}

	public String getName() {
		return name;
	}

	public String getAddress() {
		return address;
	}

	public Map<Boat, Person> getMarina() {
		return marina;
	}
	
	public void setMaxSpace(int maxSpace) {
		this.maxSpace = maxSpace;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public void setMarina(Map<Boat, Person> marina) {
		this.marina = marina;
	}
	
	
	
	
}
