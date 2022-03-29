package util;

import model.Employee;
import org.w3c.dom.*;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.IOException;
import java.util.UUID;

public class XMLParser {

    private final DocumentUtilService documentFactory = new DocumentUtilService();


    public void saveEmployee(Employee employee){
        deleteEmployee(employee.getId()); //if user exist with the same id, this method should update it

        DocumentBuilder documentBuilder = documentFactory.getDocumentBuilder();
        Document document = null;
        try {
            document = documentBuilder.parse("src/main/resources/db.xml");
        } catch (SAXException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        Element root = document.getDocumentElement();

        Element employeeNode = document.createElement("employee");

        employeeNode.setAttribute("id", employee.getId().toString());
        employeeNode.setAttribute("name", employee.getName());
        employeeNode.setAttribute("post", employee.getPost());
        employeeNode.setAttribute("company", employee.getCompany());
        employeeNode.setAttribute("email", employee.getEmail());
        employeeNode.setAttribute("phones", employee.getPhones());
        root.appendChild(employeeNode);

        DOMSource source = new DOMSource(document);



        try {
            TransformerFactory transformerFactory = TransformerFactory.newInstance();
            Transformer transformer = transformerFactory.newTransformer();
            StreamResult result = new StreamResult("src/main/resources/db.xml");
            transformer.transform(source, result);
        } catch (TransformerException e) {
            e.printStackTrace();
        }
    }

    public void deleteEmployee(UUID employeeId){
        DocumentBuilder documentBuilder = documentFactory.getDocumentBuilder();
        Document document = null;
        try {
            document = documentBuilder.parse("src/main/resources/db.xml");
        } catch (SAXException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        Element root = document.getDocumentElement();
        NodeList children = root.getElementsByTagName("employee");
        Node nodeShouldBeRemoved = null;
        for (int i = 0; i < children.getLength(); i++) {
            Node methodNode = children.item(i);
            NamedNodeMap attributes = methodNode.getAttributes();
            if (attributes.getNamedItem("id").getNodeValue().equals(employeeId.toString()))
                nodeShouldBeRemoved = methodNode;
        }
        if (nodeShouldBeRemoved != null)
            root.removeChild(nodeShouldBeRemoved);

        StreamResult result = new StreamResult("src/main/resources/db.xml");
        try {
            DOMSource source = new DOMSource(document);
            TransformerFactory transformerFactory = TransformerFactory.newInstance();
            Transformer transformer = transformerFactory.newTransformer();
            transformer.transform(source, result);
        } catch (TransformerException e) {
            e.printStackTrace();
        }
    }

    public void showAllEmployees() {
        DocumentBuilder documentBuilder = documentFactory.getDocumentBuilder();
        Document document = null;
        try {
            document = documentBuilder.parse("src/main/resources/db.xml");
        } catch (SAXException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        Element root = document.getDocumentElement();
        NodeList children = root.getElementsByTagName("employee");
        for (int i = 0; i < children.getLength(); i++){
            Node methodNode = children.item(i);
            NamedNodeMap attributes = methodNode.getAttributes();
            for (int j = 0; j < attributes.getLength(); j++)
                System.out.print(attributes.item(j).getNodeValue() + " ");
            System.out.println();
        }
    }

    public void findEmployeeById(UUID employeeId) {
        DocumentBuilder documentBuilder = documentFactory.getDocumentBuilder();
        Document document = null;
        try {
            document = documentBuilder.parse("src/main/resources/db.xml");
        } catch (SAXException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        Element root = document.getDocumentElement();
        NodeList children = root.getElementsByTagName("employee");
        for (int i = 0; i < children.getLength(); i++){
            Node methodNode = children.item(i);
            NamedNodeMap attributes = methodNode.getAttributes();
            if (attributes.getNamedItem("id").getNodeValue().equals(employeeId.toString())) {
                for (int j = 0; j < attributes.getLength(); j++)
                    System.out.print(attributes.item(j).getNodeValue() + " ");
                System.out.println();
            }
        }
    }

}
