package controller;

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
}