package controller;

import main.Notrium3D;

public class PlayerController extends Controller {
	
	private Notrium3D game;
	
	public PlayerController(Notrium3D game) {
		this.game = game;
		
		XZAxisLock = true;
	}
	
	public void rotateYaw() {
		entity.rotate(0.1f, 0, 0);
	}
	
	public void rotatePitch(float value) {
		game.getCamera().setRotation(rotation);
	}
	
	public void rotateRollLeft(float value) {
		entity.rotate(0, 1f*value, 0);
	}
	
	public void rotateRollRight(float value) {
		entity.rotate(0, -1f*value, 0);
	}
	
	public void moveForward() {
	}
	
	public void update() {
		
		location = entity.getLocalTranslation();
		rotation = entity.getLocalRotation();
		
		game.getCamera().setRotation(rotation);
		game.getCamera().setLocation(location);
	}
}
