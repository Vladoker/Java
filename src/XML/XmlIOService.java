import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Text;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.File;


public class XmlIOService {
  public static void main(String[] args) throws TransformerException, ParserConfigurationException {
    writeToFile();
  }

  public static void writeToFile() throws ParserConfigurationException, TransformerException {
    DocumentBuilderFactory domBuilderFactory = DocumentBuilderFactory.newInstance();
    DocumentBuilder domBuilder = domBuilderFactory.newDocumentBuilder();
    Document doc = domBuilder.newDocument();

    Element root = doc.createElement("employees");

    doc.appendChild(root);
    for (int i = 0; i < 3; i++) {
      Element employee = doc.createElement("employee");
      root.appendChild(employee.appendChild(
              doc.createElement("name").appendChild(doc.createTextNode("Vladislav"))
      ));

      employee.appendChild(doc.createElement("surname").appendChild(doc.createTextNode("Tomasciuc")));
    }

    doc.getDocumentElement().normalize();

    // Writing to a file

    TransformerFactory transformerFactory = TransformerFactory.newInstance();

    Transformer transformer = transformerFactory.newTransformer();

    DOMSource source = new DOMSource(doc);
    StreamResult destination = new StreamResult(new File("D:/employee.xml"));
    transformer.transform(source, destination);
  }
}
