package com.tyha;

import com.tyha.handlers.InstanceHandler;
import com.tyha.handlers.LogicHandler;

public class Program {
	private static InstanceHandler instance = new InstanceHandler();
	private static LogicHandler logic = new LogicHandler();
	
	public void start() {
		instance.init();
		logic.init();
	}
	
	public static InstanceHandler getInstance() {
		return instance;
	}

	public static LogicHandler getLogic() {
		return logic;
	}
	
	
	
}
