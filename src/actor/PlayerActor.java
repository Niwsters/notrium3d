package actor;

import com.jme3.material.Material;
import com.jme3.math.ColorRGBA;
import com.jme3.math.Vector3f;
import com.jme3.scene.Geometry;
import com.jme3.scene.shape.Box;

import main.Notrium3D;

public class PlayerActor extends Actor {
	
	private Box box;
	private Geometry box_geo;
	private Material mat;
	private Notrium3D game;

	public PlayerActor(Notrium3D game) {
		super(game);
		this.game = game;
		
		setupBox();
	}
	
	//ONLY for testing purposes
	private void setupBox() {
		box = new Box(Vector3f.ZERO, 1, 1, 1);
		box_geo = new Geometry("player_box", box);
		mat = new Material(game.getAssetManager(), "Common/MatDefs/Misc/SolidColor.j3md");
		mat.setColor("m_Color", ColorRGBA.Blue);
		box_geo.setMaterial(mat);
		
		attachChild(box_geo);
		setLocalTranslation(new Vector3f(0, 0.1f, 0));
	}
}
