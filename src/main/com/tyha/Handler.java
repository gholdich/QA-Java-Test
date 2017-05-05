package main.com.tyha;

import java.io.File;

import main.com.tyha.objects.Entitys;
import main.com.tyha.tools.FileToObject;

public class Handler {
	Entitys entitys = new Entitys();
	FileToObject parse = new FileToObject();
	
	public Handler() {
	}
	
	public void init() {
		parse.init("stage_5_input.txt");
	}
	
	
	public Entitys getEntity() {
		return entitys;
	}
	
	
	
}
