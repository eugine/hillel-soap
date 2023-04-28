package ua.ithillel.soap.server.employee;

import jakarta.jws.WebMethod;
import jakarta.jws.WebService;

import java.util.List;

@WebService
public interface EmployeeService {
    @WebMethod
    List<Employee> getEmployees();

    @WebMethod
    Employee getEmployee(int id);

    @WebMethod
    Employee updateEmployee(int id, String name);

    @WebMethod
    boolean deleteEmployee(int id);

    @WebMethod
    Employee addEmployee(int id, String name);
}