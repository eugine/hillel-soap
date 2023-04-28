package ua.ithillel.soap.server;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import ua.ithillel.soap.server.employee.Employee;
import ua.ithillel.soap.server.employee.EmployeeRepository;
import ua.ithillel.soap.server.employee.EmployeeServiceImpl;

import java.util.List;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class EmployeeServiceImplTest {

    @Mock
    private EmployeeRepository repository;
    @InjectMocks
    private EmployeeServiceImpl target;

    @Test
    void shouldGetEmployees() {
        when(repository.getAll()).thenReturn(List.of());
        var list = target.getEmployees();

        assertThat(list, equalTo(List.of()));
        verify(repository).getAll();
    }

    @Test
    void shouldGetEmployee() {
        var employee = new Employee(1, "name");
        when(repository.get(1)).thenReturn(employee);

        var actual = target.getEmployee(1);

        assertThat(actual, equalTo(employee));
        verify(repository).get(1);
    }

    @Test
    void shouldUpdateEmployee() {
        var employee = new Employee(1, "name");
        when(repository.update(1, "name")).thenReturn(employee);

        var actual = target.updateEmployee(1, "name");

        assertThat(actual, equalTo(employee));
        verify(repository).update(1, "name");
    }

    @Test
    void shouldDeleteEmployee() {
        when(repository.delete(1)).thenReturn(true);

        var actual = target.deleteEmployee(1);

        assertThat(actual, equalTo(true));
        verify(repository).delete(1);
    }

    @Test
    void shouldAddEmployee() {
        var employee = new Employee(1, "name");
        when(repository.add(1, "name")).thenReturn(employee);

        var actual = target.addEmployee(1, "name");

        assertThat(actual, equalTo(employee));
        verify(repository).add(1, "name");
    }
}