package states;

import main.Notrium3D;

import com.jme3.app.state.AbstractAppState;
import com.jme3.font.BitmapFont;
import com.jme3.font.BitmapText;
import com.jme3.input.MouseInput;
import com.jme3.math.ColorRGBA;
import com.jme3.math.Vector2f;

public class MenuState extends AbstractAppState{
	
	BitmapFont hudFont;
	BitmapText hudText;
	Notrium3D game;
	
	public MenuState(Notrium3D game) {
		this.game = game;
		
		buildMenu();
	}
	
	public void update(float tpf) {
		
		if(hudText.getLocalTranslation().getY()
				>= game.getInputManager().getCursorPosition().y
				&& hudText.getLocalTranslation().getY()
				<= game.getInputManager().getCursorPosition().y + hudText.getLineHeight()
				&& hudText.getLocalTranslation().getX() + hudText.getLineWidth()
				>= game.getInputManager().getCursorPosition().x
				&& hudText.getLocalTranslation().getX()
				<= game.getInputManager().getCursorPosition().x) {
			if(hudText.getColor() != ColorRGBA.Red) {
				hudText.setColor(ColorRGBA.Red);
			}
		} else {
			if(hudText.getColor() != ColorRGBA.White) {
				hudText.setColor(ColorRGBA.White);
			}
		}
	}
	
	private void buildMenu() {
		hudFont = game.getAssetManager().loadFont("Interface/Fonts/Default.fnt");
		
		hudText = new BitmapText(hudFont, false);
		hudText.setText("START");
		hudText.setLocalTranslation(300,
				hudText.getLineHeight()+(240-hudText.getLineHeight()/2),
				0);
		game.getGUINode().attachChild(hudText);
	}
}
