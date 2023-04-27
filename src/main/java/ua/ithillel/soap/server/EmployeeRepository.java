package ua.ithillel.soap.server;

import java.util.*;
import java.util.stream.Collectors;

public class EmployeeRepository {

    private final Map<Integer, Employee> employees;

    public EmployeeRepository() {
        this.employees = new HashMap<>();
    }

    public EmployeeRepository(List<Employee> employees) {
        this.employees = new HashMap<>();
        employees.forEach(employee -> this.employees.put(employee.getId(), employee));
    }

    public List<Employee> getAll() {
        return new ArrayList<>(employees.values());
    }

    public Employee get(int id) {
        return employees.get(id);
    }

    public Employee update(int id, String name) {
        return Optional.ofNullable(employees.get(id))
                .stream()
                .peek(employee -> employee.setName(name))
                .findAny()
                .orElse(null);
    }

    public boolean delete(int id) {
        return employees.remove(id) != null;
    }

    public Employee add(int id, String name) {
        return employees.put(id, new Employee(id, name));
    }
}
