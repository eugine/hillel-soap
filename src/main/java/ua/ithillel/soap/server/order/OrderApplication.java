package ua.ithillel.soap.server.order;

import jakarta.xml.ws.Endpoint;

import java.util.List;

public class OrderApplication {

    public static void main(String[] args) {
        var bindingURI = "http://localhost:8080/orderService";
        var service = new OrderServiceImpl(createRepository());
        Endpoint.publish(bindingURI, service);
    }

    private static OrderRepository createRepository() {
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
        return new InMemoryOrderRepository(orders);
    }
}

