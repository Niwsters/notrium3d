package function;

import main.Notrium3D;

public class Effect {
	
	protected Notrium3D game;
	
	public Effect(Notrium3D game) {
		this.game = game;
	}
	
	public void execute() {
	}
	
	//TODO: Make a "get...()"-chain all the way to the actor and/or controller,
	//to give the effect more resources to work with. This will hopefully improve
	//flexibility by a lot!
}
