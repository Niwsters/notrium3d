package function;

import item.InventoryItem;
import item.Item;
import main.Notrium3D;

import com.jme3.light.DirectionalLight;
import com.jme3.math.ColorRGBA;

public class LightEffect extends Effect {
	
	private boolean activated = false;
	private DirectionalLight light;
	
	public LightEffect(Notrium3D game) {
		super(game);
		
		light = new DirectionalLight();
		light.setColor(ColorRGBA.Yellow);
		
		game.getRootNode().addLight(light);
	}
	
	public void update() {
	}
	
	public void execute() {
	}
}
