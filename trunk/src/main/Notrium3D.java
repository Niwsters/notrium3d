package main;

import world.WorldGenerator;

import com.jme3.app.SimpleBulletApplication;

import entity.actor.PlayerActor;

public class Notrium3D extends SimpleBulletApplication {
	
	public void simpleInitApp() {
		WorldGenerator wg = new WorldGenerator(this);
		wg.initWorld();
		
		PlayerActor player = new PlayerActor(this);
		rootNode.attachChild(player);
		getPhysicsSpace().add(player);
	}
	
	public static void main(String[] args) {
		Notrium3D app = new Notrium3D();
		app.start();
	}
}
