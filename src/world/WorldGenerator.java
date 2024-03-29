package world;

import main.Notrium3D;

import com.jme3.asset.TextureKey;
import com.jme3.bullet.control.RigidBodyControl;
import com.jme3.material.Material;
import com.jme3.math.ColorRGBA;
import com.jme3.math.Vector3f;
import com.jme3.renderer.queue.RenderQueue.Bucket;
import com.jme3.scene.Geometry;
import com.jme3.scene.shape.Box;
import com.jme3.scene.shape.Sphere;
import com.jme3.texture.Texture;

public class WorldGenerator{
	
	private Geometry floor_geo;
	private RigidBodyControl floor_phy;
	private Material material;
	
	private Notrium3D game;
	
	private Sphere sphereMesh = new Sphere(10, 10, 100, false, true);
	private Geometry skySphere = new Geometry("Sky", sphereMesh);
	
	public WorldGenerator(Notrium3D game) {
		this.game = game;
	}
	
	public void initWorld() {
		initMaterials();
		
		//Initialize floor geometry and physics
		floor_geo = new Geometry("Floor", new Box(Vector3f.ZERO, 10f, 0.1f, 5f));
		floor_geo.setMaterial(material);
		floor_phy = new RigidBodyControl(0.0f);
		floor_geo.addControl(floor_phy);
		game.getBulletAppState().getPhysicsSpace().add(floor_phy);
		
		game.getRootNode().attachChild(floor_geo);
		 
	    // Load a sky sphere using a sky texture from jme3test-test-data
	    skySphere.updateModelBound();
	    skySphere.setQueueBucket(Bucket.Sky);
	 
	    TextureKey key = new TextureKey("Textures/Sky/Bright/BrightSky.dds", true);
	    key.setGenerateMips(true);
	    key.setAsCube(true);
	    Texture tex = game.getAssetManager().loadTexture(key);
	 
	    Material sky_mat = new Material(game.getAssetManager(), "Common/MatDefs/Misc/Sky.j3md");
	    sky_mat.setTexture("m_Texture", tex);
	    sky_mat.setVector3("m_NormalScale", Vector3f.UNIT_XYZ);
	    skySphere.setMaterial(sky_mat);
	 
	    game.getRootNode().attachChild(skySphere);
	}
	
	private void initMaterials() {
		material = new Material(game.getAssetManager(), "Common/MatDefs/Light/Lighting.j3md");
        material.setBoolean("m_UseMaterialColors", true);
        material.setFloat("m_Shininess", 12);
        material.setColor("m_Ambient",  ColorRGBA.Black);
        material.setColor("m_Diffuse",  ColorRGBA.Gray);
        material.setColor("m_Specular", ColorRGBA.Gray);
	}
}
