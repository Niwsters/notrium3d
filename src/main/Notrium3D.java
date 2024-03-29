package main;

import states.MenuState;
import trigger.TriggerHandler;

import com.jme3.app.Application;
import com.jme3.renderer.queue.RenderQueue.Bucket;
import com.jme3.scene.Node;
import com.jme3.scene.Spatial.CullHint;
import com.jme3.system.AppSettings;

public class Notrium3D extends Application {
	
	Node guiNode;
	Node rootNode;
	
	TriggerHandler triggerHandler;
	
	public Notrium3D() {
		super();
		guiNode = new Node("GUI Node");
		rootNode = new Node("Root Node");
		
		triggerHandler = new TriggerHandler(this);
	}
	
	public void start() {
        setSettings(new AppSettings(true));
        
        super.start();
	}
	
	public void initialize() {
		super.initialize();
		
		MenuState menuState = new MenuState(this);
		stateManager.attach(menuState);
		
		guiNode.setQueueBucket(Bucket.Gui);
		guiNode.setCullHint(CullHint.Never);
		
		guiViewPort.attachScene(guiNode);
	}
	
	public void update() {
		super.update();
		
		float tpf = timer.getTimePerFrame();
		
		stateManager.update(tpf);
		stateManager.render(renderManager);
		
        rootNode.updateLogicalState(tpf);
        guiNode.updateLogicalState(tpf);
        rootNode.updateGeometricState();
        guiNode.updateGeometricState();
        
		renderManager.render(tpf);
	}
	
	public static void main(String[] args) {
		Notrium3D app = new Notrium3D();
		app.start();
	}
	
	public Node getGUINode() {
		return guiNode;
	}
	
	public Node getRootNode() {
		return rootNode;
	}
	
	public TriggerHandler getTriggerHandler() {
		return triggerHandler;
	}
}
