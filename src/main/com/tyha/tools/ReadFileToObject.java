package com.tyha.tools;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;

import com.tyha.Program;
import com.tyha.objects.Boat;
import com.tyha.objects.Marina;
import com.tyha.objects.Person;

public class ReadFileToObject {

	  private final static Charset ENCODING = StandardCharsets.UTF_8; 
	  private final Path fFilePath; 
	  
	  public ReadFileToObject(String aFileName){
		    fFilePath = Paths.get(aFileName);
		  }
	  
	  public void processFile() throws IOException {
		  StringBuilder sb = new StringBuilder();
		    try (BufferedReader reader = Files.newBufferedReader(fFilePath, ENCODING)){
		      String line = null;
		      while ((line = reader.readLine()) != null) {
		        sb.append(line).append("\n");
		      }      
		    }
			String[][] objects = processLine(sb.append("\n").toString());
			processObjects(objects);
			
		  }
	  
	  protected String[][] processLine(String aLine){
		    String[] seperateGroups = aLine.replace("Marinas\n\n", "").replace("Boats\n\n", "").replace("People\n\n", "").split("\n\n");
		    String[][] objects = new String[seperateGroups.length][];
		    Arrays.stream(seperateGroups).forEach(e 
					-> objects[Arrays.asList(seperateGroups).indexOf(e)] 
							= seperateGroups[Arrays.asList(seperateGroups).indexOf(e)].split("\\|"));		    
		    for(int i = 0; i < objects.length; i++)
		    	for(int j = 0; j < objects[i].length; j++)
		    		objects[i][j] = objects[i][j].trim();
			return objects;
	  }
	  
	  protected void processObjects(String[][] objects) {
		//<---START of Process Marina Objects
		  String[][] marinas = new String[objects[0].length][];
		  Arrays.stream(objects[0]).forEach(e 
					-> marinas[Arrays.asList(objects[0]).indexOf(e)] 
							= objects[0][Arrays.asList(objects[0]).indexOf(e)].split("\n"));
		//END of Processing Marina Objects--->
		  
		//<---START of Process Boat Objects
		  String[][] boats = new String[objects[1].length][];
		  Arrays.stream(objects[1]).forEach(e 
					-> boats[Arrays.asList(objects[1]).indexOf(e)] 
							= objects[1][Arrays.asList(objects[1]).indexOf(e)].split("\n"));
		//END of Processing Boat Objects--->
		  
		//<---START of Process Person Objects
		  String[][] persons = new String[objects[2].length][];
		  Arrays.stream(objects[2]).forEach(e 
					-> persons[Arrays.asList(objects[2]).indexOf(e)] 
							= objects[2][Arrays.asList(objects[2]).indexOf(e)].split("\n"));
		//END of Processing Person Objects--->
		  
		  createObjects(marinas, boats, persons);
	  }
	  
	  protected void createObjects(String[][] marinas, String[][] boats, String[][] persons) {
			//<---START of create Marina Objects
		    for(int i = 0; i < marinas.length; i++)
		    	Program.getInstance().getEntity().getMarinaList().add(
		    			new Marina(marinas[i][0], marinas[i][1], Integer.parseInt(marinas[i][2]))
		    			);
			//END of creating Marina Objects--->
		    
			//<---START of create Boat Objects
		    for(int i = 0; i < boats.length; i++)
		    	Program.getInstance().getEntity().getBoatList().add(
		    			new Boat(boats[i][0], boats[i][1], Double.parseDouble(boats[i][2]))
		    			);
			//END of creating Boat Objects--->
		    
			//<---START of create Person Objects
		    for(int i = 0; i < persons.length; i++) {
		    	String[] fullName = persons[i][0].contains(" ") ? persons[i][0].split(" ") : new String[]{ persons[i][0], "" };
		    	
			    if(Arrays.toString(persons[i]).contains("British") || persons[i].length == 3)
				    Program.getInstance().getEntity().getPersonList().add(
				    		new Person(fullName[0], fullName[1], persons[i][1], persons[i][2])
				    		);
			    
			    else if(persons[i].length == 4)
				    Program.getInstance().getEntity().getPersonList().add(
				    		new Person(fullName[0], fullName[1], persons[i][1], persons[i][2], persons[i][3])
				    		);
				//END of creating Person Objects--->
		    }
	  }
	
}
