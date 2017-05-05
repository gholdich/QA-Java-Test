package main.com.tyha.objects.persons;

import main.com.tyha.objects.Person;

public class NonUK extends Person {
	
	private String visaInformation;

	public NonUK(String firstName, String surname, String dateOfBirth, String nationality, String visaInformation) {
		super(firstName, surname, dateOfBirth, nationality);
		this.visaInformation = visaInformation;
	}

	public String getVisaInformation() {
		return visaInformation;
	}
	public void setVisaInformation(String visaInformation) {
		this.visaInformation = visaInformation;
	}

}
