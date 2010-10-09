package controller;

import com.jme3.math.Quaternion;
import com.jme3.math.Vector3f;

import entity.Entity;

public class Controller {
	
	protected Entity entity;
	protected Quaternion rotation;
	protected Vector3f location;
	protected boolean XZAxisLock;
	
	public Controller() {
	}
	
	public void setEntity(Entity entity) {
		this.entity = entity;
	}
	
	public void lockXZAxis() {
		if(XZAxisLock) {
			if(entity.getLocalRotation().getX() != 0 ||
					entity.getLocalRotation().getZ() != 0) {
				
				entity.rotateUpTo(new Vector3f(180f, entity.getLocalRotation().getY(), 180f));
			}
		}
	}
	
	public void update() {
		lockXZAxis();
	}
}