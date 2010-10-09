package entity.actor;

import controller.Controller;
import main.Notrium3D;
import entity.Entity;

public class Actor extends Entity {
	
	protected Controller controller;
	
	public Actor(Notrium3D game) {
		super(game);
		
		setMass(1.0f);
	}
	
	public void setController(Controller controller) {
		this.controller = controller;
		controller.setEntity(this);
	}
}
