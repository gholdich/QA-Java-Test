package main.com.tyha.tools;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FileToObject {
	
	private final static Charset encoding = StandardCharsets.UTF_8;
	List<String> lines = new ArrayList<>();
	
	public void init(String fileName) {
		readFile(fileName);
	}

	public void readFile(String fileName) {
		Path path = Paths.get(fileName);
			try (BufferedReader read = Files.newBufferedReader(path, encoding)) {
				String line = null;
				while((line = read.readLine()) != null) {
					lines.add(line);
				}
				sortFileData();
			} catch (IOException e) {
				e.printStackTrace();
			}
	}
	
	
	public void sortFileData() {
		List<String> str = new ArrayList<>();
		StringBuilder sb = new StringBuilder();
		int index = 0;
		for(String line: lines){
			if(line.isEmpty()){
				sb = new StringBuilder();
				continue;
			}
			if(line.equals("|")){
				str.add(sb.toString());
				System.out.println(sb.toString());
				sb = new StringBuilder();
				continue;
			}
			sb.append("'").append(line).append("'");
		}
		
		
		/*String[] seperateGroups = sb.split("\\|");
		String[][] objects = new String[seperateGroups.length][];
		Arrays.stream(seperateGroups).forEach(e 
				-> objects[Arrays.asList(seperateGroups).indexOf(e)] 
						= seperateGroups[Arrays.asList(seperateGroups).indexOf(e)].split("-"));*/
		
		//for(int i = 0; i < objects.length; i++) {
			//for(int j = 0; j < objects[i].length; j++) {
				//System.out.println(objects[1][0]);
			//}
		//}

	}
	
	
	
}
