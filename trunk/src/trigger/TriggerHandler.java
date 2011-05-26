package trigger;

import java.util.ArrayList;

import function.Function;

import main.Notrium3D;

public class TriggerHandler {
	
	protected ArrayList<Trigger> triggers;
	protected ArrayList<InputTrigger> actionInputs;
	protected ArrayList<InputTrigger> analogInputs;
	protected Notrium3D game;
	
	public TriggerHandler(Notrium3D game) {
		this.game = game;
		
		triggers = new ArrayList<Trigger>();
		actionInputs = new ArrayList<InputTrigger>();
		analogInputs = new ArrayList<InputTrigger>();
	}
	
	public void update() {
		for(Trigger t: triggers) {
			t.check();
		}
	}
	
	public void addTrigger(Trigger t) {
		triggers.add(t);
	}
	
	public void addInputTrigger(InputTrigger t, boolean analog) {
		if(analog) {
			analogInputs.add(t);
		} else {
			actionInputs.add(t);
		}
	}
	
	public ArrayList<InputTrigger> getAnalogInputTriggers() {
		return analogInputs;
	}
	
	public ArrayList<InputTrigger> getActionInputTriggers() {
		return actionInputs;
	}
}
