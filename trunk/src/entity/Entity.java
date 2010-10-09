package entity;

import main.Notrium3D;

import com.jme3.bullet.nodes.PhysicsNode;
import com.jme3.scene.Geometry;
import com.jme3.scene.Spatial;

public abstract class Entity extends PhysicsNode {
	
	protected Notrium3D game;
	protected Spatial model;
	
	public Entity(Notrium3D game) {
		this.game = game;
	}
	
	//For loading a 3D model
	public void setModel(String ref) {
		detachChild(model);
		model = game.getAssetManager().loadModel(ref);
		attachChild(model);
	}
	
	//For setting a native geometry as a model
	public void setModel(Geometry geo) {
		detachChild(model);
		model = geo;
		attachChild(model);
	}
}
