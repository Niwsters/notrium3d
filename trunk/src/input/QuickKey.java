package input;

import item.Item;

public class QuickKey {
	
	int key;
	Item item;
	String command;
	String nameOfFunction;
	
	public QuickKey(Item item, String command, String nameOfFunction, int key) {
		this.command = command;
		this.key = key;
		this.item = item;
		this.nameOfFunction = nameOfFunction;
	}
	
	public void execute() {
		item.executeFunction(nameOfFunction);
	}
	
	public int getKey() {
		return key;
	}
	
	public String getCommand() {
		return command;
	}
}
