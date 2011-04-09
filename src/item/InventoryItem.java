package item;

import inventory.Inventory;

import com.jme3.ui.Picture;

import main.Notrium3D;

public class InventoryItem extends Item {
	
	protected boolean equipped;
	protected Inventory inventory;
	protected Picture image;
	
	public InventoryItem(Notrium3D game, Inventory inventory) {
		super(game);
		this.inventory = inventory;
	}
	
	public Inventory getInventory() {
		return inventory;
	}
}