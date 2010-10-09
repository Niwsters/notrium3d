package main;

import world.WorldGenerator;

import com.jme3.app.SimpleBulletApplication;

import controller.PlayerController;

import entity.actor.PlayerActor;

public class Notrium3D extends SimpleBulletApplication {
	
	private PlayerController playerController;
	private KeyInputHandler keyInputHandler;
	private PlayerActor player;
	
	public Notrium3D() {
		super();
	}
	
	public void simpleInitApp() {
		keyInputHandler = new KeyInputHandler(this);
		keyInputHandler.initKeys();
		playerController = new PlayerController(this);
		
		WorldGenerator wg = new WorldGenerator(this);
		wg.initWorld();
		
		player = new PlayerActor(this);
		player.setController(playerController);
		rootNode.attachChild(player);
		getPhysicsSpace().add(player);
	}
	
	public void simpleUpdate(float tpf) {
		playerController.update();
	}
	
	public static void main(String[] args) {
		Notrium3D app = new Notrium3D();
		app.start();
	}
	
	public PlayerController getPlayerController() {
		return playerController;
	}
}
