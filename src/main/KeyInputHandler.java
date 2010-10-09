package main;

import com.jme3.input.KeyInput;
import com.jme3.input.MouseInput;
import com.jme3.input.controls.ActionListener;
import com.jme3.input.controls.AnalogListener;
import com.jme3.input.controls.KeyTrigger;
import com.jme3.input.controls.MouseAxisTrigger;

public class KeyInputHandler{
	
	//Arrays to store all the commands, NOT the keys themselves, which the keys will trigger
	private String[] analogMapping = {"Forward", "Backward", "Strafeleft", "Straferight",
			"RollRotateLeft", "RollRotateRight"};
	private String[] actionMapping = {};
	
	//For accessing the game object
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
	
	//This is for continuous key listening, think "isPressed"
    public AnalogListener analogListener = new AnalogListener() {
		public void onAnalog(String name, float value, float tpf) {
			if(name.equals("RollRotateLeft")) {
				game.getPlayerController().rotateRollLeft(value);
			}
			if(name.equals("RollRotateRight")) {
				game.getPlayerController().rotateRollRight(value);
			}
			if(name.equals("YawRotateUp")) {
				game.getPlayerController().rotatePitch(value);
			}
		}
    };
    
    //This is for one-time press
    public ActionListener actionListener = new ActionListener() {
		public void onAction(String name, boolean value, float tpf) {
		}
    };
    
    //Initialize the mapping for all keys
    private void initMapping() {
    	game.getInputManager().addMapping("Forward", new KeyTrigger(KeyInput.KEY_W));
    	game.getInputManager().addMapping("Backward", new KeyTrigger(KeyInput.KEY_S));
    	game.getInputManager().addMapping("Strafeleft", new KeyTrigger(KeyInput.KEY_A));
    	game.getInputManager().addMapping("Straferight", new KeyTrigger(KeyInput.KEY_D));
    	
    	game.getInputManager().addMapping("RollRotateLeft", new MouseAxisTrigger(MouseInput.AXIS_X, true));
    	game.getInputManager().addMapping("RollRotateRight", new MouseAxisTrigger(MouseInput.AXIS_X, false));
    	game.getInputManager().addMapping("YawRotateUp", new MouseAxisTrigger(MouseInput.AXIS_Y, true));
    	game.getInputManager().addMapping("YawRotateDown", new MouseAxisTrigger(MouseInput.AXIS_Y, false));
    }
}
