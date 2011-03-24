package trigger;

import java.util.ArrayList;

import function.Function;

public class Trigger {
	protected boolean triggered = false;
	protected ArrayList<Function> functions = new ArrayList<Function>();
	
	public void update() {
		
		check();
		
		if(triggered) {
			for(Function f: functions) {
				f.execute();
			}
		}
	}
	
	protected void check() {
	}
}