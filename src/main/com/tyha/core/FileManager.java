package com.tyha.core;

import java.io.IOException;
import java.nio.file.NoSuchFileException;

import com.tyha.tools.ReadFileToObject;

public class FileManager {

	public void parseObjectsFromFile(String filePath) {
	    ReadFileToObject parser = new ReadFileToObject(filePath);
	    try {
			parser.processFile();
		} catch (NoSuchFileException e) {
			System.err.println("File: "+e.getMessage()+" cannot be located on the filesystem.");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
}
