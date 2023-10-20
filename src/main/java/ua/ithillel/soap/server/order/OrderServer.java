package ua.ithillel.soap.server.order;

import jakarta.xml.ws.Endpoint;
import ua.ithillel.soap.server.employee.EmployeeService;

import java.util.List;

public class OrderServer {

    public static void main(String[] args) {
        var bindingURI = "http://localhost:8080/orderService";
        var webService = createService();
        Endpoint.publish(bindingURI, webService);
    }

    private static OrderService createService() {
        return new OrderServiceImpl(orderRepository());
    }

    private static OrderRepository orderRepository() {
        var orders = List.of(
                new Order(1, List.of(
                        new Product(1, "product-1", 100),
                        new Product(2, "product-2", 200))
                ),
                new Order(2, List.of(
                        new Product(3, "product-3", 300),
                        new Product(4, "product-4", 400))
                )
        );
        return new OrderRepository(orders);
    }
}
