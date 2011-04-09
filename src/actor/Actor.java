package actor;

import inventory.Inventory;
import main.Notrium3D;

import com.jme3.material.Material;
import com.jme3.math.ColorRGBA;
import com.jme3.math.Vector3f;
import com.jme3.scene.Geometry;
import com.jme3.scene.Node;
import com.jme3.scene.shape.Sphere;

import controller.Controller;

public class Actor extends Node {
	
	protected Controller controller;
	protected Inventory inventory;
	protected Notrium3D game;
	protected Vector3f walkDirection = Vector3f.ZERO;

	public Actor(Notrium3D game) {
		this.game = game;
		makeSphere();
		
		inventory = new Inventory(game, this);
	}
	
	public void update() {
	}
	
	//This is for setting the controller
	//after the Actor has been created
	public void setController(Controller controller) {
		this.controller = controller;
		this.controller.setActor(this);
	}
	
	//ONLY for testing purposes
	private void makeSphere() {
		Sphere sphere = new Sphere(32, 32, 1f);
		Geometry sphere_geo = new Geometry("Player", sphere);
		Material mat = new Material(game.getAssetManager(),
				"Common/MatDefs/Misc/SolidColor.j3md");
		mat.setColor("m_Color", ColorRGBA.Blue);
		sphere_geo.setMaterial(mat);
		
		attachChild(sphere_geo);
		setLocalTranslation(new Vector3f(0, 2, 0));
	}
	
	public Vector3f getWalkDirection() {
		return walkDirection;
	}
	
	public Inventory getInventory() {
		return inventory;
	}
}
