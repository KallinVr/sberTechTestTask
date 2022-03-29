import model.Employee;
import org.w3c.dom.Document;
import org.xml.sax.SAXException;
import service.EmployeeServiceImpl;
import util.XMLParser;

import javax.xml.transform.*;
import java.io.IOException;
import java.util.Scanner;
import java.util.UUID;

public class Main {

    private static EmployeeServiceImpl employeeService = new EmployeeServiceImpl();

    public static void main(String[] args) throws TransformerException, IOException, SAXException {
        Scanner scanner = new Scanner(System.in);
        int output;
        while (true)
        {
            System.out.println("нажмите необходимую цифру чтобы:");
            System.out.println("1 Добавить клиента");
            System.out.println("2 Редактировать клиента");
            System.out.println("3 Удалить клиента");
            System.out.println("4 Показать список клиентов");
            System.out.println("5 Найти клиента");
            System.out.println("6 выйти");

            output = scanner.nextInt();

            if (output == 1){
                String name;
                String post;
                String company;
                String email;
                String phones;
                System.out.println("Введите имя");
                name = scanner.nextLine();
                System.out.println("Введите должность");
                post = scanner.nextLine();
                System.out.println("Введите компанию");
                company = scanner.nextLine();
                System.out.println("введите email");
                email = scanner.nextLine();
                System.out.println("Введите мобильный(-ые) телефон(-ы)");
                phones = scanner.nextLine();

                employeeService.save(new Employee(UUID.randomUUID(), name, post, company, email, phones));
            } else if (output == 2){
                UUID id;
                String name;
                String post;
                String company;
                String email;
                String phones;
                System.out.println("Введите id клиента которого хотите изменить");
                id = UUID.fromString(scanner.next());
                System.out.println("Введите имя");
                name = scanner.nextLine();
                System.out.println("Введите должность");
                post = scanner.nextLine();
                System.out.println("Введите компанию");
                company = scanner.nextLine();
                System.out.println("введите email");
                email = scanner.nextLine();
                System.out.println("Введите мобильный(-ые) телефон(-ы)");
                phones = scanner.nextLine();

                employeeService.save(new Employee(id, name, post, company, email, phones));
            } else if (output == 3){
                System.out.println("Введите id клиента которого хотите удалить");
                employeeService.deleteById(UUID.fromString(scanner.next()));
            } else if (output == 4){
                employeeService.findAll();
            } else if (output == 5) {
                System.out.println("Введите id клиента о котором хотите узнать");
                employeeService.findById(UUID.fromString(scanner.next()));
            } else {
                break;
            }
        }

    }
}
