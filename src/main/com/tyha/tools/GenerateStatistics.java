package com.tyha.tools;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Comparator;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import com.tyha.Program;
import com.tyha.objects.Marina;
import com.tyha.objects.Person;

public class GenerateStatistics {

	public void oldestPersonPerMooredBoat() {
		String format = "dd/MM/yyyy";
		SimpleDateFormat dateFormat = new SimpleDateFormat(format);
		Map<Long, Person> ages = new HashMap<Long, Person>();
		Program.getInstance().getEntity().getMarinaList()
				.stream()
				.map(m -> m.getMarina().keySet())
				.forEach(m -> m
						.stream()
						.forEach(b -> b.personnelAssociated()
								.stream()
								.map(e -> {
									try {
										long milliTime = dateFormat.parse(e.getDateOfBirth()).getTime();
										ages.put(milliTime, e);
											return milliTime;
										} catch (ParseException e1) {
											e1.printStackTrace();
										}
											return null;
									}).min(Comparator.comparing(i -> i))
										.ifPresent(min-> System.out.println(
												"The oldest Person on the "
												+b.getName()+" is "
												+ages.get(min.longValue()).getFirstName()+" "
												+ages.get(min.longValue()).getSurname()
												+" with an age of "
												+(Math.abs((min-(new Date().getTime()))/365/24/60/60/1000)+".")
										))
						)
				);
	}
	
	public void oldestPersonPerMarina() {
		String format = "dd/MM/yyyy";
		SimpleDateFormat dateFormat = new SimpleDateFormat(format);
		Map<Long, Person> ages = new HashMap<Long, Person>();
		Program.getInstance().getEntity().getMarinaList()
				.stream()
				.map(m -> m.getMarina().entrySet())
				.forEach(m -> {
					Set<Person> personsPerMarina = new HashSet<Person>();
					Marina marina = m.stream().findFirst().orElse(null).getValue();
						m.stream()
						.forEach(b ->
						b.getKey().personnelAssociated()
								.stream()
								.forEach(e -> personsPerMarina.add(e))
						);
						personsPerMarina.stream().map(p -> {
						try {
							long milliTime = dateFormat.parse(p.getDateOfBirth()).getTime();
							ages.put(milliTime, p);
								return milliTime;
							} catch (ParseException e1) {
								e1.printStackTrace();
							}
								return null;
						}).min(Comparator.comparing(i -> i))
							.ifPresent(min-> System.out.println(
									"The oldest Person at "
									+marina.getName()+" is "
									+ages.get(min.longValue()).getFirstName()+" "
									+ages.get(min.longValue()).getSurname()
									+" with an age of "
									+(Math.abs((min-(new Date().getTime()))/365/24/60/60/1000)+".")
							));
				});

	}
	
	public void numberOfMooredBoatsPerMarina() {
		Program.getInstance().getEntity().getMarinaList()
						.stream()
						.map(m -> m.getMarina().entrySet())
						.forEach(m -> {
							int num = (int) m.stream().count();
								System.out.println("There "
								+(num > 1 ? "are" : "is")
								+" currently "
								+num
								+(num > 1 ? " Boats" : " Boat")
								+" moored at "
								+m.stream().findFirst()
								.orElse(null)
								.getValue().getName()+".");
						});
	}
	
	public void mapAllBoatsInAMarina() {
		Program.getInstance().getEntity().getMarinaList()
				.stream()
				.map(m -> m.getMarina().entrySet())
				.forEach(m -> m.stream()
				.map(e -> e.getKey().getName()+" --> "+e.getValue().getName())
				.forEach(System.out::println));
	}
	
	public void allPersonsCurrentlyInHarbourPerBoat() {
		Program.getInstance().getEntity().getMarinaList()
				.stream()
				.map(m -> m.getMarina().entrySet())
				.forEach(m -> m
						.stream()
						.forEach(b -> b.getKey().personnelAssociated()
								.stream()
								.peek(p -> { 
									if(b.getKey().personnelAssociated().indexOf(p) == 0)
										System.out.println("["+b.getKey().getName()+"]");
								})
								.map(p ->
									+b.getKey().personnelAssociated().indexOf(p)+1+") Name: "
									+p.getFirstName()+" "+p.getSurname()+" - Role on "
									+b.getKey().getName()+": "
									+(b.getKey().getOwners().contains(p) ? "Owner," : "")
									+(b.getKey().getCaptain() != null && b.getKey().getCaptain().equals(p) ? "Captin," : "")
									+(b.getKey().getCrew().contains(p) ? "Crew," : "")
									+" Date of Birth: "+p.getDateOfBirth()
									+", Nationality: "+p.getNationality()
									+(p.getVisaInformation() != null ? ", Visa Information: "+p.getVisaInformation() : "")
								).forEach(System.out::println)));
	}
	
}
