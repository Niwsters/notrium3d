package main;

import com.jme3.app.SimpleApplication;

import item.ItemHandler;
import item.WorldItem;

import world.WorldGenerator;
import com.jme3.app.state.*;
import com.jme3.app.state.AppStateManager;
import com.jme3.bullet.BulletAppState;

import actor.ActorHandler;

import com.jme3.app.SimpleApplication;
import com.jme3.bullet.BulletAppState;

public class Notrium3D extends SimpleApplication {
	
	private BulletAppState bulletAppState;
	
	private ActorHandler actorHandler;
	private ItemHandler itemHandler;
	private KeyInputHandler keyInputHandler;
	private WorldGenerator worldGenerator;
	private AppStateManager stateManager;
	
	public Notrium3D() {
		super();
	}
	
	public void simpleInitApp() {
		bulletAppState = new BulletAppState();
		stateManager.attach(bulletAppState);
		
		keyInputHandler = new KeyInputHandler(this);
		keyInputHandler.initKeys();
		
		worldGenerator = new WorldGenerator(this);
		worldGenerator.initWorld();
		
		actorHandler = new ActorHandler(this);
		actorHandler.setupActors();
		
		//Setup the app state manager
		stateManager.attach(new BulletAppState());
		
		itemHandler = new ItemHandler(this);
		itemHandler.init();
		
		WorldItem item = itemHandler.getAbstractItem("Flashlight").toWorldItem();
		item.makeBox();
		itemHandler.addWorldItem(item);
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
	
	public ItemHandler getItemHandler() {
		return itemHandler;
	}
	
	public BulletAppState getBulletAppState() {
		return bulletAppState;
	}
}
