import java.util.ArrayList;
import java.io.File;
import java.io.IOException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;


public class Loader implements ILoader{

  @Override
  public ArrayList<IBuilding> load(String filename) throws ParserConfigurationException, SAXException, IOException {
    // TODO Auto-generated method stub
    ArrayList<IBuilding> list = new ArrayList<IBuilding>();
    DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
    DocumentBuilder db = dbf.newDocumentBuilder();
    File file = new File(filename);
    Document doc = db.parse(file);
    NodeList nlist = doc.getElementsByTagName("Building");
    ArrayList<IBuilding> records = new ArrayList<IBuilding>();
    
    for(int i = 0; i < nlist.getLength(); i ++) {
      
      Element ele = (Element) nlist.item(i);
      String name = ele.getElementsByTagName("name").item(0).getChildNodes().item(0).getNodeValue();
      Integer x = Integer.parseInt(ele.getElementsByTagName("x").item(0).getChildNodes().item(0).getNodeValue());
      Integer y = Integer.parseInt(ele.getElementsByTagName("y").item(0).getChildNodes().item(0).getNodeValue());
      String tf = ele.getElementsByTagName("isBus").item(0).getChildNodes().item(0).getNodeValue();
      boolean tfbool = false;
      if(tf.equals("t")) {
        tfbool = true;
      }
      IBuilding building = new Building(name, x, y, tfbool);
      records.add(building);
    }
    
    ArrayList<String> dtrack = new ArrayList<String>();
    for(int i = 0; i < nlist.getLength(); i ++) {
      Element ele = (Element) nlist.item(i);
      String d1 = ele.getElementsByTagName("connection1").item(0).getChildNodes().item(0).getNodeValue();
      String d2 = ele.getElementsByTagName("connection2").item(0).getChildNodes().item(0).getNodeValue();
      String d3 = ele.getElementsByTagName("connection3").item(0).getChildNodes().item(0).getNodeValue();
      dtrack.add(d1);
      dtrack.add(d2);
      if(d3.equals("null")) {
        d3 = null;
      }
      else {
        dtrack.add(d3);
      }
      for(int j = 0; j < dtrack.size(); j ++) {
        for(int k = 0; k < records.size(); k ++) {
          if(dtrack.get(j).equals((records.get(k).getName()))) {
            records.get(i).addDestination(records.get(k));
          }
        }
      }
      list.add(records.get(i));
      
    }
    
    return list;
  }

}
