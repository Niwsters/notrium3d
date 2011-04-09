package item;

import inventory.Inventory;

import java.util.ArrayList;

import com.jme3.scene.Node;

import function.Function;

import main.Notrium3D;

public class Item extends Node {
	
	protected ArrayList<Function> functions;
	protected boolean equippable = false;
	protected Notrium3D game;
	protected String name = "";
	
	public Item(Notrium3D game) {
		this.game = game;
		functions = new ArrayList<Function>();
	}
	
	public void addFunction(Function f) {
		functions.add(f);
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public void setEquippable(boolean equippable) {
		this.equippable = equippable;
	}
	
	public String getName() {
		return name;
	}
	
	public ArrayList<Function> getFunctionList() {
		return functions;
	}
	
	public InventoryItem toInventoryItem(Inventory inventory) {
		InventoryItem i = new InventoryItem(game, inventory);
		
		i.setName(name);
		i.setEquippable(equippable);
		for(Function f: functions) {
			i.addFunction(f);
		}
		
		return i;
	}
	
	public WorldItem toWorldItem() {
		WorldItem i = new WorldItem(game);
		
		i.setName(name);
		i.setEquippable(equippable);
		for(Function f: functions) {
			i.addFunction(f);
		}
		
		return i;
	}
	
	public void executeFunction(String nameOfFunction) {
		for(Function f: functions) {
			if(f.getName().equals(nameOfFunction)) {
				f.execute();
			}
		}
	}
}
