package actor;

import main.Notrium3D;
import controller.PlayerController;

public class ActorHandler {
	
	public Actor player;
	private Notrium3D game;
	private PlayerController playerController;
	
	public ActorHandler(Notrium3D game) {
		this.game = game;
	}
	
	public void setupActors() {
		player = new Actor(game);
		playerController = new PlayerController(game, player);
		
		game.getRootNode().attachChild(player);
	}
	
	public void update() {
		playerController.update();
	}
	
	public PlayerController getPlayerController() {
		return playerController;
	}
}
