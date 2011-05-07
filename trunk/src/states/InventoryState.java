package states;

import com.jme3.app.Application;
import com.jme3.app.state.*;
import com.jme3.renderer.RenderManager;

//This AppState would be attached to the state manager, over the BulletAppState.
//

public class InventoryState extends AbstractAppState {

	//private Inventory inventory; //eventual reference
	
	public InventoryState() {
		
	}
	
	@Override
	public void update(float tpf)
	{
		super.update(tpf);

	}
}
