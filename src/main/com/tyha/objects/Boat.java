package main.com.tyha.objects;

import java.util.ArrayList;
import java.util.LinkedList;

import main.com.tyha.interfaces.Vehicle;

public class Boat implements Vehicle  {
	
	private String name;
	private String countryOfOrigin;
	private double size;
	ArrayList<Person> owners = new ArrayList<Person>();
	LinkedList<Person> staff = new LinkedList<Person>();
	
	
	
	@Override
	public int getSpeed() {
		// TODO Auto-generated method stub
		return 0;
	}
	@Override
	public void accelerate() {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void deccelerate() {
		// TODO Auto-generated method stub
		
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
	public void setName(String name) {
		this.name = name;
	}
	public void setCountryOfOrigin(String countryOfOrigin) {
		this.countryOfOrigin = countryOfOrigin;
	}
	public void setSize(double size) {
		this.size = size;
	}

}
