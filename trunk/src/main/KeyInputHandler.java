package main;

import com.jme3.input.KeyInput;
import com.jme3.input.MouseInput;
import com.jme3.input.controls.ActionListener;
import com.jme3.input.controls.AnalogListener;
import com.jme3.input.controls.KeyTrigger;
import com.jme3.input.controls.MouseAxisTrigger;

public class KeyInputHandler {
	
	public boolean Forward, Backward, StrafeLeft, StrafeRight,
	TurnLeft, TurnRight, PickUpItem, ActivateItem = false;
	
	//Arrays to store all the commands, NOT the keys themselves, which the keys will trigger
	private String[] analogMapping = {"TurnLeft", "TurnRight", "PickUpItem", "ActivateItem"};
	private String[] actionMapping = {"Forward", "Backward", "StrafeLeft", "StrafeRight"};
	private Notrium3D game;
	
	public KeyInputHandler(Notrium3D game) {
		this.game = game;
	}
	
	public void initKeys() {
		initMapping();
		
		//Initialize the listeners into the game
		game.getInputManager().addListener(analogListener, analogMapping);
		game.getInputManager().addListener(actionListener, actionMapping);
	}
	
    public AnalogListener analogListener = new AnalogListener() {
		public void onAnalog(String name, float value, float tpf) {
			if(name.equals("PickUpItem")) {
				PickUpItem = true;
			} else {
				PickUpItem = false;
			}
			if(name.equals("ActivateItem")) {
				ActivateItem = true;
			} else {
				ActivateItem = false;
			}
		}
    };
    
    public ActionListener actionListener = new ActionListener() {
		public void onAction(String name, boolean value, float tpf) {
			if(name.equals("StrafeLeft")) {
				if(value) {
					StrafeLeft = true;
				} else {
					StrafeLeft = false;
				}
			}
			if(name.equals("StrafeRight")) {
				if(value) {
					StrafeRight = true;
				} else {
					StrafeRight = false;
				}
			}
			if(name.equals("Forward")) {
				if(value) {
					Forward = true;
				} else {
					Forward = false;
				}
			}
			if(name.equals("Backward")) {
				if(value) {
					Backward = true;
				} else {
					Backward = false;
				}
			}
		}
    };
    
    //TODO: Finish this. It's supposed to make us able to add keys from outside classes.
    public void addInput(boolean analog, String command, int key) {
    	game.getInputManager().addMapping(command, new KeyTrigger(key));
    }
    
    //Initialize the mapping for all keys
    private void initMapping() {
    	game.getInputManager().addMapping("Forward", new KeyTrigger(KeyInput.KEY_U));
    	game.getInputManager().addMapping("Backward", new KeyTrigger(KeyInput.KEY_J));
    	game.getInputManager().addMapping("StrafeLeft", new KeyTrigger(KeyInput.KEY_H));
    	game.getInputManager().addMapping("StrafeRight", new KeyTrigger(KeyInput.KEY_K));
    	
    	game.getInputManager().addMapping("TurnLeft", new MouseAxisTrigger(MouseInput.AXIS_X, true));
    	game.getInputManager().addMapping("TurnRight", new MouseAxisTrigger(MouseInput.AXIS_X, false));
    	game.getInputManager().addMapping("YawRotateUp", new MouseAxisTrigger(MouseInput.AXIS_Y, true));
    	game.getInputManager().addMapping("YawRotateDown", new MouseAxisTrigger(MouseInput.AXIS_Y, false));
    	
    	game.getInputManager().addMapping("PickUpItem", new KeyTrigger(KeyInput.KEY_Y));
    	game.getInputManager().addMapping("ActivateItem", new KeyTrigger(KeyInput.KEY_E));
    }
}
