package fileio;

import function.Function;
import item.Item;

import java.io.InputStream;

import main.Notrium3D;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import net.sf.json.JSONSerializer;
import net.sf.json.JSONString;

public class JSONItemParser {
	
	private Notrium3D game;

	public JSONItemParser(Notrium3D game) {
		this.game = game;
	}
	
	public Item read(String ref) {
		InputStream is =
			JSONString.class.getResourceAsStream(ref);
		String jsonTxt = is.toString();
		JSONObject itemInfo = (JSONObject) JSONSerializer.toJSON(jsonTxt);
		
		Item item = new Item(game);
		item.setName(itemInfo.getString("name"));
		item.setEquippable(itemInfo.getBoolean("equippable"));
		
		JSONArray functionsInfo = itemInfo.getJSONArray("functions");
		
		for(int i=0; i<functionsInfo.size(); i++) {
			JSONObject functionInfo = functionsInfo.getJSONObject(i);
			JSONArray conditionsInfo = functionInfo.getJSONArray("conditions");
			JSONArray effectsInfo = functionInfo.getJSONArray("effects");
			
			Function f = new Function();
			f.setName(functionInfo.getString("name"));
			
			for(int j=0; j<conditionsInfo.size(); j++) {
			}
			
			for(int j=0; j<effectsInfo.size(); j++) {
			}
			
			item.addFunction(f);
		}
		
		return item;
	}
}
