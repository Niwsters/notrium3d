package main;

import world.WorldGenerator;

import com.jme3.app.SimpleBulletApplication;

public class Notrium3D extends SimpleBulletApplication {
	
	private ActorHandler actorHandler;
	private KeyInputHandler keyInputHandler;
	private WorldGenerator worldGenerator;
	
	public Notrium3D() {
		super();
	}
	
	public void simpleInitApp() {
		keyInputHandler = new KeyInputHandler(this);
		keyInputHandler.initKeys();
		
		//Initialize the terrain
		worldGenerator = new WorldGenerator(this);
		worldGenerator.initWorld();
		
		//Setup all the starting actors
		actorHandler = new ActorHandler(this);
		actorHandler.setupActors();
	}
	
	public void simpleUpdate(float tpf) {
		actorHandler.update();
	}
	
	public static void main(String[] args) {
		Notrium3D app = new Notrium3D();
		app.start();
	}
	
	public KeyInputHandler getKeyInputHandler() {
		return keyInputHandler;
	}
	
	public ActorHandler getActorHandler() {
		return actorHandler;
	}
}
