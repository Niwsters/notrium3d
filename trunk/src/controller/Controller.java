package controller;

import item.InventoryItem;
import item.WorldItem;
import main.Notrium3D;
import actor.Actor;

public class Controller {
	
	protected Actor actor;
	protected Notrium3D game;
	
	public Controller(Notrium3D game, Actor actor) {
		this.game = game;
		this.actor = actor;
	}
	
	public void update() {
	}

	public void setActor(Actor actor) {
		this.actor = actor;
	}
	
	public void pickUpItem() {
		InventoryItem ii;
		
		if(game.getItemHandler().getWorldItems().size() > 1) {
			for(WorldItem i: game.getItemHandler().getWorldItems()) {
				
				if(i.getLocalTranslation().distance(actor.getLocalTranslation()) < 2) {
					
					ii = game.getItemHandler()
					.getAbstractItem(i.getName()).toInventoryItem(actor.getInventory());
					
					game.getItemHandler().removeWorldItem(i);
					actor.getInventory().addItem(ii);
					System.out.println("Inventory list: "
							+ actor.getInventory().getItemsList().size());
				}
			}
		} else if(game.getItemHandler().getWorldItems().size() > 0){
			WorldItem i = game.getItemHandler().getWorldItems().get(0);
			
			if(i.getLocalTranslation().distance(actor.getLocalTranslation()) < 2) {
				
				ii = game.getItemHandler()
				.getAbstractItem(i.getName()).toInventoryItem(actor.getInventory());
				
				game.getItemHandler().removeWorldItem(i);
				actor.getInventory().addItem(ii);
				System.out.println("Inventory list: "
						+ actor.getInventory().getItemsList().size());
				System.out.println(actor.getInventory().getItemsList().get(0).getName());
			}
		}
	}
}