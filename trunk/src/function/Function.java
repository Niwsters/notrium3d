package function;

import java.util.ArrayList;

public class Function {
	protected ArrayList<Condition> conditions;
	protected ArrayList<Effect> effects;
	protected String name, key = "";
	
	public Function() {
		conditions = new ArrayList<Condition>();
		effects = new ArrayList<Effect>();
	}
	
	public Function(ArrayList<Condition> conditions,
			ArrayList<Effect> effects) {
		this.conditions = conditions;
		this.effects = effects;
	}
	
	public void addEffect(Effect effect) {
		effects.add(effect);
	}
	
	public void addCondition(Condition condition) {
		conditions.add(condition);
	}
	
	public void execute() {
		int check = 0;
		
		//Check through all the function's conditions, and add a mark for each one
		for(Condition c: conditions) {
			if(c.check()) {
				check++;
			}
		}
		
		//If the amount of marks equal the amount of conditions, execute effects
		if(check == conditions.size()) {
			for(Effect e: effects) {
				e.execute();
			}
		}
	}
	
	public ArrayList<Condition> getConditions() {
		return conditions;
	}
	
	public ArrayList<Effect> getEffects() {
		return effects;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String getName() {
		return name;
	}
}
