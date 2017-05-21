package com.tyha.objects;

public class Person {
	
	private String firstName;
	private String surname;
	private String dateOfBirth;
	private String nationality;
	private String visaInformation;
	
	public Person(String firstName, String surname, String dateOfBirth, String nationality) {
		this.firstName = firstName;
		this.surname = surname;
		this.dateOfBirth = dateOfBirth;
		this.nationality = nationality;
	}
	
	public Person(String firstName, String surname, String dateOfBirth, String nationality, String visaInformation) {
		this(firstName, surname, dateOfBirth, nationality);
		this.setVisaInformation(visaInformation);
	}

	public String getFirstName() {
		return firstName;
	}
	public String getSurname() {
		return surname;
	}
	public String getDateOfBirth() {
		return dateOfBirth;
	}
	public String getNationality() {
		return nationality;
	}
	public String getVisaInformation() {
		return visaInformation;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public void setSurname(String surname) {
		this.surname = surname;
	}
	public void setDateOfBirth(String dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}
	public void setNationality(String nationality) {
		this.nationality = nationality;
	}
	public void setVisaInformation(String visaInformation) {
		this.visaInformation = visaInformation;
	}
	
}
