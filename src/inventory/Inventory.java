package inventory;

import java.util.ArrayList;

import actor.Actor;

import com.jme3.scene.Node;

import main.Notrium3D;

import item.InventoryItem;

public class Inventory extends Node {
	
	protected Actor actor;
	protected ArrayList<InventoryItem> items;
	protected Notrium3D game;
	
	public Inventory(Notrium3D game, Actor actor) {
		this.game = game;
		this.actor = actor;
		
		items = new ArrayList<InventoryItem>();
	}
	
	public void addItem(InventoryItem item) {
		items.add(item);
		System.out.println("Put it in the inventory!");
	}
	
	public ArrayList<InventoryItem> getItemsList() {
		return items;
	}
	
	public Actor getActor() {
		return actor;
	}
}