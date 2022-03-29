package service;

import model.Employee;
import org.xml.sax.SAXException;
import util.XMLParser;

import javax.xml.transform.TransformerException;
import java.io.IOException;
import java.util.UUID;

public class EmployeeServiceImpl implements EmployeeService {

    XMLParser xmlParser = new XMLParser();

    @Override
    public void save(Employee employee) {
        xmlParser.saveEmployee(employee);
    }

    @Override
    public void update(Employee employee) {
        xmlParser.saveEmployee(employee);
    }

    @Override
    public void deleteById(UUID id) {
        xmlParser.deleteEmployee(id);
    }

    @Override
    public void findAll() {
        xmlParser.showAllEmployees();
    }

    @Override
    public void findById(UUID id) {
        xmlParser.findEmployeeById(id);
    }
}
