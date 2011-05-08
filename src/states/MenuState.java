package states;

import com.jme3.app.Application;
import com.jme3.app.state.AbstractAppState;
import com.jme3.niftygui.NiftyJmeDisplay;

import de.lessvoid.nifty.Nifty;
import de.lessvoid.nifty.screen.Screen;
import de.lessvoid.nifty.screen.ScreenController;

public class MenuState extends AbstractAppState implements ScreenController {
	
	Nifty nifty;
	NiftyJmeDisplay niftyDisplay;
	
	public MenuState(Application app) {
		niftyDisplay = new NiftyJmeDisplay(
				app.getAssetManager(),
				app.getInputManager(),
				app.getAudioRenderer(),
				app.getGuiViewPort());
		
		nifty = niftyDisplay.getNifty();
		
		nifty.fromXml("states/MainMenu.xml", "start", this);
		
		app.getGuiViewPort().addProcessor(niftyDisplay);
	}
	
	public void bind(Nifty nifty, Screen screen) {
	}
	
	public void onEndScreen() {
	}
	
	public void onStartScreen() {
	}
	
	public void update(float tpf) {
	}
}
