package states;

import com.jme3.app.Application;
import com.jme3.app.state.AbstractAppState;
import com.jme3.app.state.AppState;
import com.jme3.app.state.AppStateManager;
import com.jme3.renderer.RenderManager;

import com.jme3.input.InputManager;
import com.jme3.input.KeyInput;
import com.jme3.input.MouseInput;
import com.jme3.input.controls.ActionListener;
import com.jme3.input.controls.AnalogListener;
import com.jme3.input.controls.KeyTrigger;
import com.jme3.input.controls.MouseButtonTrigger;

public class MenuState extends AbstractAppState {
	
	//Must declare graphics for the menu here.
	
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
		
	}
	
	public void update(float tpf)
	{
		
	}

	public void render(RenderManager rm)
	{
		//Must render previously mentioned graphics here.
	}
}
