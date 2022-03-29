import model.Employee;
import org.junit.jupiter.api.*;
import org.w3c.dom.*;
import org.xml.sax.SAXException;
import service.EmployeeServiceImpl;
import util.DocumentUtilService;

import javax.xml.parsers.DocumentBuilder;
import java.io.IOException;
import java.util.UUID;


public class Tests {

    EmployeeServiceImpl employeeService = new EmployeeServiceImpl();
    DocumentUtilService documentFactory = new DocumentUtilService();


    @Test
    public void checkIfAddingWorks(){
        String expected = "company1 email1 f19f111a-95ae-4777-aa83-a8202503477e name1 phone1 post1 ";
        String actual = "";


        employeeService.save(new Employee(UUID.fromString("f19f111a-95ae-4777-aa83-a8202503477e"), "name1",
                "post1", "company1", "email1", "phone1"));

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
            if (attributes.getNamedItem("id").getNodeValue().equals("f19f111a-95ae-4777-aa83-a8202503477e")) {
                for (int j = 0; j < attributes.getLength(); j++)
                    actual += (attributes.item(j).getNodeValue() + " ");
            }
        }
        Assertions.assertEquals(expected, actual);
        employeeService.deleteById(UUID.fromString("f19f111a-95ae-4777-aa83-a8202503477e"));
    }

    @Test
    public void checkIfUpdatingWorks(){
        String expected = "company2 email2 f19f111a-95ae-4777-aa83-a8202503477e name2 phone2 post2 ";
        String actual = "";


        employeeService.save(new Employee(UUID.fromString("f19f111a-95ae-4777-aa83-a8202503477e"), "name2",
                "post2", "company2", "email2", "phone2"));

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
            if (attributes.getNamedItem("id").getNodeValue().equals("f19f111a-95ae-4777-aa83-a8202503477e")) {
                for (int j = 0; j < attributes.getLength(); j++)
                    actual += (attributes.item(j).getNodeValue() + " ");
            }
        }
        Assertions.assertEquals(expected, actual);
        employeeService.deleteById(UUID.fromString("f19f111a-95ae-4777-aa83-a8202503477e"));
    }

    @Test
    public void checkIfDeletingWorks(){
        String expected = "";
        String actual = "";

        employeeService.save(new Employee(UUID.fromString("f19f111a-95ae-4777-aa83-a8202503477e"), "name2",
                "post2", "company2", "email2", "phone2"));
        employeeService.deleteById(UUID.fromString("f19f111a-95ae-4777-aa83-a8202503477e"));

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
            if (attributes.getNamedItem("id").getNodeValue().equals("f19f111a-95ae-4777-aa83-a8202503477e")) {
                for (int j = 0; j < attributes.getLength(); j++)
                    actual += (attributes.item(j).getNodeValue() + " ");
            }
        }

        Assertions.assertEquals(expected, actual);

    }
}
