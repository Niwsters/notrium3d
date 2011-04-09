package controller;

import actor.Actor;
import main.Notrium3D;

public class PlayerController extends Controller {
	
	public PlayerController(Notrium3D game, Actor actor) {
		super(game, actor);
	}
	
	public void update() {
		updateActor();
		updateCamera();
	}
	
	private void updateActor() {
		actor.getWalkDirection().set(0, 0, 0);
		
		if(game.getKeyInputHandler().StrafeLeft) {
			actor.getWalkDirection().addLocal(game.getCamera().getLeft().mult(0.1f));
		}
		if(game.getKeyInputHandler().StrafeRight) {
			actor.getWalkDirection().addLocal(game.getCamera().getLeft().mult(0.1f).negate());
		}
		if(game.getKeyInputHandler().Forward) {
			actor.getWalkDirection().addLocal(game.getCamera().getDirection().mult(0.1f));
		}
		if(game.getKeyInputHandler().Backward) {
			actor.getWalkDirection().addLocal(game.getCamera().getDirection().mult(0.1f).negate());
		}
		
		if(game.getKeyInputHandler().PickUpItem) {
			pickUpItem();
		}
		if(game.getKeyInputHandler().ActivateItem) {
			actor.getInventory().getItemsList().get(0).executeFunction("Light");
			System.out.println("Activating light...");
		}
		
		actor.update();
	}
	
	private void updateCamera() {
		game.getCamera().setLocation(actor.getLocalTranslation());
	}
	
	public Actor getActor() {
		return actor;
	}
}
