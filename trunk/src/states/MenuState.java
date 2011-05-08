package states;

import main.Notrium3D;

import com.jme3.app.state.AbstractAppState;
import com.jme3.font.BitmapFont;
import com.jme3.font.BitmapText;

public class MenuState extends AbstractAppState{
	
	BitmapFont hudFont;
	BitmapText hudText;
	
	public MenuState(Notrium3D app) {
		hudFont = app.getAssetManager().loadFont("Interface/Fonts/Default.fnt");
		
		hudText = new BitmapText(hudFont, false);
		hudText.setText("START");
		hudText.setLocalTranslation(300, hudText.getLineHeight(), 0);
		app.getGUINode().attachChild(hudText);
	}
	
	public void update(float tpf) {
	}
}
