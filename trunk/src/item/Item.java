package item;

import main.Notrium3D;

import com.jme3.bullet.collision.shapes.SphereCollisionShape;
import com.jme3.bullet.nodes.PhysicsNode;
import com.jme3.material.Material;
import com.jme3.math.ColorRGBA;
import com.jme3.math.Vector3f;
import com.jme3.scene.Geometry;
import com.jme3.scene.shape.Box;

public class Item extends PhysicsNode {
	
	private Notrium3D game;
	
	public Item(Notrium3D game) {
		super(new SphereCollisionShape(1f));
		
		this.game = game;
	}
	
	public void makeBox() {
		Box box = new Box(Vector3f.ZERO, 1, 1, 1);
		Geometry box_geo = new Geometry("Item", box);
		Material mat = new Material(game.getAssetManager(),
		"Common/MatDefs/Misc/SolidColor.j3md");
		mat.setColor("m_Color", ColorRGBA.Blue);
		box_geo.setMaterial(mat);
		attachChild(box_geo);
	}
}
