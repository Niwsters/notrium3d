package fileio;

import function.Function;
import function.LightEffect;
import item.Item;

import java.io.File;
import java.io.IOException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import main.Notrium3D;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

public class XMLItemReader {
	
	private Document doc;
	private Element itemElement;
	private Notrium3D game;
	
	public XMLItemReader(Notrium3D game) {
		this.game = game;
	}
	
	public void read(String ref, Item item) {
		try {
			File file = new File(ref);
			DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
			DocumentBuilder db = dbf.newDocumentBuilder();
			doc = db.parse(file);
			doc.getDocumentElement().normalize();
		} catch (ParserConfigurationException e) {
			e.printStackTrace();
		} catch (SAXException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		gather(item);
	}
	
	private void gather(Item item) {
		itemElement = (Element) doc.getChildNodes().item(0);
		
		item.setName(getNodeValue("name", itemElement));
		
		NodeList functionList = itemElement.getElementsByTagName("function");
		for(int i = 0; i < functionList.getLength(); i++) {
			Element functionElement = (Element) functionList.item(i);
			System.out.println("Function element name: " + functionList.item(i).getNodeName());
			Function f = new Function();
			
			f.setName(getNodeValue("nameoffunction", functionElement));
			System.out.println("Function name: " + f.getName());
			
			NodeList conditionList = functionElement.getElementsByTagName("conditions");
			
			//Add conditions
			for(int j = 0; j < conditionList.getLength(); j++) {
			}
			
			NodeList effectList = functionElement.getElementsByTagName("effects");
			Element effects = (Element) effectList.item(0);
			
			//Add effects
			for(int j = 0; j < effectList.getLength(); j++) {
				Element effectElement = (Element) effects.getElementsByTagName("effect").item(j);
				
				if(getNodeValue("type", effectElement).equals("light")) {
					LightEffect le = new LightEffect(game);
					f.addEffect(le);
					System.out.println("OMG LIGHT ADDED!!111");
				}
			}
			
			item.addFunction(f);
		}
	}
	
	private String getNodeValue(String tag, Element e) {
		NodeList nlList = itemElement.getElementsByTagName(tag).item(0).getChildNodes();
		Node nValue = nlList.item(0);
		
		return nValue.getNodeValue();
	}
}
