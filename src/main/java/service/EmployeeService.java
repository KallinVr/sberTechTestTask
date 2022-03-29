package service;

import model.Employee;
import org.xml.sax.SAXException;

import javax.xml.transform.TransformerException;
import java.io.IOException;
import java.util.UUID;

/**
 * Method for work with Employee
 */

public interface EmployeeService {

    void save(Employee employee);

    void update(Employee employee);

    void deleteById(UUID id);

    void findAll();

    void findById(UUID id);

}