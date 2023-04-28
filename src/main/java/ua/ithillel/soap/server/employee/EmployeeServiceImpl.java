package ua.ithillel.soap.server.employee;

import jakarta.jws.WebMethod;
import jakarta.jws.WebService;
import lombok.RequiredArgsConstructor;

import java.util.List;

@RequiredArgsConstructor
@WebService(endpointInterface = "ua.ithillel.soap.server.employee.EmployeeService")
public class EmployeeServiceImpl implements EmployeeService {

    private final EmployeeRepository employeeRepositoryImpl;

    @Override
    public List<Employee> getEmployees() {
        System.out.println("calling getEmployees");
        return employeeRepositoryImpl.getAll();
    }

    @WebMethod
    public Employee getEmployee(int id) {
        System.out.printf("calling getEmployee[id=%s]%n", id);
        return employeeRepositoryImpl.get(id);
    }

    @WebMethod
    public Employee updateEmployee(int id, String name) {
        System.out.printf("calling updateEmployee[id=%s, name=%s]%n", id, name);
        return employeeRepositoryImpl.update(id, name);
    }

    @WebMethod
    public boolean deleteEmployee(int id) {
        System.out.printf("calling deleteEmployee[id=%s]%n", id);
        return employeeRepositoryImpl.delete(id);
    }

    @WebMethod
    public Employee addEmployee(int id, String name) {
        System.out.printf("calling addEmployee[id=%s, name=%s]%n", id, name);
        return employeeRepositoryImpl.add(id, name);
    }
}