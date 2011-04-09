package item;

import java.io.File;
import java.util.ArrayList;

import main.Notrium3D;

import fileio.XMLItemReader;

public class ItemHandler {
	protected ArrayList<Item> abstractItems; //ONLY FOR LOADING AND COPYING XML INFO
	protected ArrayList<WorldItem> removeList;
	protected ArrayList<WorldItem> worldItems;
	protected ArrayList<String> xmlFileList;
	protected Notrium3D game;
	protected XMLItemReader xmlreader;
	
	public ItemHandler(Notrium3D game) {
		this.game = game;
		
		abstractItems = new ArrayList<Item>();
		removeList = new ArrayList<WorldItem>();
		worldItems = new ArrayList<WorldItem>();
		xmlFileList = new ArrayList<String>();
		xmlreader = new XMLItemReader(game);
	}
	
	private void loadItems() {
		File itemsFolder = new File("data/Items");
		File[] itemsFolderList = itemsFolder.listFiles();
		
		//First load all the .xml-files from each separate item-folder
		for(File f: itemsFolderList) {
			File[] items = f.listFiles();
			for(File g: items) {
				if(g.getName().endsWith(".xml")) {
					xmlFileList.add(g.getPath());
				}
			}
		}
		
		//Then read the information into the items
		for(String ref: xmlFileList) {
			Item i = new Item(game);
			xmlreader.read(ref, i);
			abstractItems.add(i);
		}
	}
	
	public void init() {
		loadItems();
	}
	
	public void update() {
	}
	
	public Item getAbstractItem(String name) {
		for(Item i: abstractItems) {
			if(i.getName().equals(name)) {
				return i;
			}
		}
		System.out.println("Cannot find item: " + name);
		return new Item(game);
	}
	
	public ArrayList<WorldItem> getWorldItems() {
		return worldItems;
	}
	
	public void addWorldItem(WorldItem i) {
		worldItems.add(i);
	}
	
	public void removeWorldItem(WorldItem i) {
		i.remove();
	}
}
