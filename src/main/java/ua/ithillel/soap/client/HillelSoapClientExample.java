package ua.ithillel.soap.client;

import lombok.SneakyThrows;
import ua.ithillel.soap.server.client.Employee;
import ua.ithillel.soap.server.client.EmployeeServiceImplService;

import java.net.URL;

public class HillelSoapClientExample {

    @SneakyThrows
    public static void main(String[] args) {
        var url = new URL("http://localhost:8080/employeeService?wsdl");

        var service = new EmployeeServiceImplService(url);
        var proxy = service.getEmployeeServiceImplPort();

        System.out.println("get all: ");
        proxy.getEmployees().forEach(HillelSoapClientExample::printEmployee);

        System.out.println("getting by id: ");
        printEmployee(proxy.getEmployee(2));

        System.out.println("deleting by id: ");
        System.out.println(proxy.deleteEmployee(3));

        System.out.println("updating: ");
        printEmployee(proxy.updateEmployee(4, "Sophie Peterson"));

        System.out.println("create new: ");
        proxy.addEmployee(3, "Evgeniy Sokolov");

        System.out.println("get all: ");
        proxy.getEmployees().forEach(HillelSoapClientExample::printEmployee);
    }

    private static void printEmployee(Employee employee) {
        System.out.printf("Employee [id=%s, name=%s]%n", employee.getId(), employee.getName());
    }


}
