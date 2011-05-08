package trigger;

public class KeyTrigger extends Trigger {
	
	protected int key;
	protected String command;
	
	public KeyTrigger(int key, String command) {
		this.key = key;
		this.command = command;
	}
	
	protected void check() {
		
	}
}
