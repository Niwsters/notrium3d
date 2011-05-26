package input;

import java.util.ArrayList;

import trigger.InputTrigger;

import main.Notrium3D;

import com.jme3.input.KeyInput;
import com.jme3.input.MouseInput;
import com.jme3.input.controls.ActionListener;
import com.jme3.input.controls.AnalogListener;
import com.jme3.input.controls.KeyTrigger;
import com.jme3.input.controls.MouseAxisTrigger;

public class KeyInputHandler {
	
	private ArrayList<InputTrigger> actionInputTriggers;
	private ArrayList<InputTrigger> analogInputTriggers;
	private ArrayList<String> actionList;
	private ArrayList<String> analogList;
	private Notrium3D game;
	
	public boolean StrafeLeft, StrafeRight, Forward, Backward, PickUpItem, ActivateItem = false;
	
	public KeyInputHandler(Notrium3D game) {
		this.game = game;
		
		actionInputTriggers = new ArrayList<InputTrigger>();
		analogInputTriggers = new ArrayList<InputTrigger>();
		actionList = new ArrayList<String>();
		analogList = new ArrayList<String>();
	}
    
    private void initMapping() {
    }
	
	public void initKeys() {
		initMapping();
		
		game.getInputManager().addListener(analogListener,
				analogList.toArray(new String[analogList.size()]));
		game.getInputManager().addListener(actionListener,
				actionList.toArray(new String[actionList.size()]));
	}
	
    private AnalogListener analogListener = new AnalogListener() {
		public void onAnalog(String name, float value, float tpf) {
			for(InputTrigger t: game.getTriggerHandler().getAnalogInputTriggers()) {
				if(name == t.getCommand()) {
					t.check();
				}
			}
		}
    };
    
    private ActionListener actionListener = new ActionListener() {
		public void onAction(String name, boolean value, float tpf) {
			for(InputTrigger t: game.getTriggerHandler().getActionInputTriggers()) {
				if(name == t.getCommand()) {
					t.check();
				}
			}
		}
    };
    
    public void addInput(boolean analog, String command, int key) {
    	game.getInputManager().addMapping(command, new KeyTrigger(key));
    	
    	if(analog) {
        	game.getInputManager().addListener(analogListener, command);
    	} else {
    		game.getInputManager().addListener(actionListener, command);
    	}
    }
    
    public void addInputTrigger(InputTrigger t, boolean analog) {
    	
    	if(analog) {
    		analogInputTriggers.add(t);
    	} else {
    		actionInputTriggers.add(t);
    	}
    }
}
