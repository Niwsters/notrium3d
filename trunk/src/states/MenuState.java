package states;

import com.jme3.app.Application;
import com.jme3.app.SimpleApplication;
import com.jme3.app.state.AbstractAppState;
import com.jme3.app.state.AppState;
import com.jme3.app.state.AppStateManager;
import com.jme3.renderer.RenderManager;
import com.jme3.scene.Node;

import com.jme3.font.BitmapFont;
import com.jme3.font.BitmapText;
import com.jme3.input.InputManager;
import com.jme3.input.KeyInput;
import com.jme3.input.MouseInput;
import com.jme3.input.controls.ActionListener;
import com.jme3.input.controls.AnalogListener;
import com.jme3.input.controls.KeyTrigger;
import com.jme3.input.controls.MouseButtonTrigger;
import com.jme3.math.ColorRGBA;

public class MenuState extends AbstractAppState {
	
	private Node guiNode; //Must declare graphics for the menu here.
	
	private int sel;
	private boolean selUp;
	private boolean selDown;
	
	public MenuState()
	{
		sel = 0;
		selUp = false;
		selDown = false;
	}
	
	@Override
	public void initialize(AppStateManager asm, Application app)
	{
		//Problems here.
		BitmapFont font = app.getAssetManager().loadFont("Interface/Fonts/Console.fnt");
		
		BitmapText hudText = new BitmapText(font, false);
		hudText.setSize(font.getCharSet().getRenderedSize());      	// font size
		hudText.setColor(ColorRGBA.Blue);                             // font color
		hudText.setText("HERE'S A TEST STRING!"); 	 	 	          // the text
		hudText.setLocalTranslation(300, hudText.getLineHeight(), 0); // position
		
		guiNode = new Node("Menu GUI Node");
		guiNode.attachChild(hudText);
	
		((SimpleApplication)app).getGuiNode().attachChild(guiNode);
	}
	
	public void up()
	{
		selUp = true;
	}
	
	public void down()
	{
		selDown = true;
	}	
	
	public void update(float tpf)
	{
		
		if (selUp && sel > 0)
			sel--;
		if (selDown && sel < 3)
			sel++;
		
		selUp = false;
		selDown = false;
	}
}
