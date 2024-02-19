
import java.io.IOException;
import java.util.ArrayList;
import javax.xml.parsers.ParserConfigurationException;
import org.xml.sax.SAXException;

public interface ILoader{

        public ArrayList<IBuilding> load(String file) throws ParserConfigurationException, SAXException, IOException;

}
