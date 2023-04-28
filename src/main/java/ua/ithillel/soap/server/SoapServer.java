package ua.ithillel.soap.server;

import jakarta.xml.ws.Endpoint;
import ua.ithillel.soap.server.employee.Employee;
import ua.ithillel.soap.server.employee.EmployeeRepository;
import ua.ithillel.soap.server.employee.EmployeeService;
import ua.ithillel.soap.server.employee.EmployeeServiceImpl;

import java.util.List;

public class SoapServer {
    public static void main(String[] args) {
        var bindingURI = "http://localhost:8080/employeeService";
        EmployeeService webService = createService();
        Endpoint.publish(bindingURI, webService);
        System.out.println("Server started at: " + bindingURI);
    }

    private static EmployeeService createService() {
        return new EmployeeServiceImpl(repository());
    }

    private static EmployeeRepository repository() {
        var employees = List.of(
                new Employee(1, "John Doe"),
                new Employee(2, "Emily Wang"),
                new Employee(3, "Kevin Kim"),
                new Employee(4, "Sophie Johnson")
        );
        return new EmployeeRepository(employees);
    }
}
