package entity;

import main.Notrium3D;

import com.jme3.bullet.nodes.PhysicsNode;
import com.jme3.scene.Geometry;
import com.jme3.scene.Spatial;

public abstract class Entity extends PhysicsNode {
	
	private Notrium3D game;
	private Spatial model;
	
	private float direction;
	private float velocity;
	
	public Entity(Notrium3D game) {
		this.game = game;
	}
	
	public void update() {
		setLocalTranslation(0, 0, 0);
	}
	
	//For loading a 3D model
	public void setModel(String ref) {
		model = game.getAssetManager().loadModel(ref);
	}
	
	//For setting a native geometry as a model
	public void setModel(Geometry geo) {
		model = geo;
	}
}
