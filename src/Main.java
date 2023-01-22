import org.w3c.dom.*;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.File;
import java.io.IOException;

public class Main {
    public static void main(String[] args) throws ParserConfigurationException, IOException, SAXException {
//        String filePath = "company.xml";
        String filePath = "data2.xml";
//        String filePath = "data.xml";
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = factory.newDocumentBuilder();
        Document doc = builder.parse(new File(filePath));

        Node root = doc.getDocumentElement();
        System.out.println("Корневой элемент: " + root.getNodeName());
//        parseXML(filePath);
        read(root);




    }// main

    private static void read(Node node) {
        NodeList nodeList = node.getChildNodes();
        for (int i = 0; i < nodeList.getLength(); i++) {
            Node node_ = nodeList.item(i);
            if (Node.ELEMENT_NODE == node_.getNodeType()) {
                System.out.println("Текущий элемент: " + node_.getNodeName());// TODO
                Element element = (Element) node_;
                NamedNodeMap map = element.getAttributes();
                for (int j = 0; j < map.getLength(); j++) {
                    String attrName = map.item(j).getNodeName();
                    String attrValue = map.item(j).getNodeValue();
                    System.out.println("Атрибут: " + attrName + ", Значение: " + attrValue);
                }// for_j
                read(node_);
            }//if
        }// for_i
    }

}// class