package trigger;

import java.util.ArrayList;

import main.Notrium3D;

public class TriggerHandler {
	
	protected ArrayList<Trigger> triggers= new ArrayList<Trigger>();
	protected Notrium3D game;
	
	public TriggerHandler(Notrium3D game) {
		this.game = game;
	}
	
	public void update() {
	}
}
