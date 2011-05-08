package main;

import com.jme3.app.SimpleApplication;
import com.jme3.app.state.*;
import com.jme3.bullet.BulletAppState;

import states.MenuState;

import actor.ActorHandler;
import world.WorldGenerator;
import input.KeyInputHandler;
import item.ItemHandler;
import item.WorldItem;

public class Notrium3D extends SimpleApplication {
	
	private BulletAppState bulletAppState;
	private MenuState menu;
	
	private ActorHandler actorHandler;
	private ItemHandler itemHandler;
	private KeyInputHandler keyInputHandler;
	private WorldGenerator worldGenerator;
	private AppStateManager stateManager;
	
	public Notrium3D() {
		super();
	}
	
	public void simpleInitApp() {
		stateManager = this.getStateManager();
		
		bulletAppState = new BulletAppState();
		stateManager.attach(bulletAppState);
		
		//menu = new MenuState();
		//stateManager.attach(menu);
		
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
	
	public ItemHandler getItemHandler(){
		return itemHandler;
	}
	
	public BulletAppState getBulletAppState(){
		return bulletAppState;
	}
}
