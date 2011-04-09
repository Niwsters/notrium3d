package item;

import com.jme3.bullet.control.RigidBodyControl;
import com.jme3.material.Material;
import com.jme3.math.Vector3f;
import com.jme3.scene.Geometry;
import com.jme3.scene.shape.Box;

import main.Notrium3D;

public class WorldItem extends Item {
	
	private Geometry geo;
	private RigidBodyControl phy;

	public WorldItem(Notrium3D game) {
		super(game);
	}
	
	public void makeBox() {
		geo = new Geometry("item_box", new Box(Vector3f.ZERO, 0.1f, 0.1f, 0.1f));
		geo.setMaterial(new Material(game.getAssetManager(), "Common/MatDefs/Light/Lighting.j3md"));
		phy = new RigidBodyControl();
		geo.addControl(phy);
		this.attachChild(geo);
	}
	
	public Vector3f getLocalTranslation() {
		return this.getLocalTranslation();
	}
	
	public void remove() {
		this.removeFromParent();
	}
}
