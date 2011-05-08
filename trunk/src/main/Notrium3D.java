package main;

import states.MenuState;

import com.jme3.app.Application;

public class Notrium3D extends Application {
	
	public void initialize() {
		super.initialize();
		
		MenuState menuState = new MenuState(this);
		stateManager.attach(menuState);
	}
	
	public void update() {
		super.update();
		
		float tpf = timer.getTimePerFrame();
		
		stateManager.update(tpf);
		stateManager.render(renderManager);
		
		renderManager.render(tpf);
	}
	
	public static void main(String[] args) {
		Notrium3D app = new Notrium3D();
		app.start();
	}
}
