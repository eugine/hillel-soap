package ua.ithillel.soap.server.order;

import jakarta.xml.ws.Endpoint;
import ua.ithillel.soap.server.order.entity.Order;
import ua.ithillel.soap.server.order.entity.Product;
import ua.ithillel.soap.server.order.repository.InMemoryOrderRepository;
import ua.ithillel.soap.server.order.repository.OrderRepository;

import java.util.List;

public class OrderApplication {

    public static void main(String[] args) {
        var bindingURI = "http://localhost:8080/orderService";
        var webService = createService();
        Endpoint.publish(bindingURI, webService);
        System.out.println("Server started at: " + bindingURI);
    }

    private static OrderService createService() {
        return new OrderServiceImpl(repository());
    }

    private static OrderRepository repository() {
        var orders = List.of(
                new Order("order-1", List.of(
                        new Product("product-1", "Product 1", 1000),
                        new Product("product-2", "Product 2", 2000)
                )),
                new Order("order-2", List.of(
                        new Product("product-3", "Product 3", 3000),
                        new Product("product-4", "Product 4", 4000)
                ))
        );
        return new InMemoryOrderRepository(orders);
    }}
