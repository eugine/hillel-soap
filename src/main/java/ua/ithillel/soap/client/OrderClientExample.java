package ua.ithillel.soap.client;

import lombok.SneakyThrows;
import ua.ithillel.soap.order.client.Order;
import ua.ithillel.soap.order.client.OrderServiceImplService;
import ua.ithillel.soap.server.client.EmployeeServiceImplService;

import java.net.URL;

public class OrderClientExample {

    @SneakyThrows
    public static void main(String[] args) {
        var url = new URL("http://localhost:8080/orderService?wsdl");

        var service = new OrderServiceImplService(url);
        var proxy = service.getOrderServiceImplPort();

        System.out.println("get all: ");
        proxy.getOrders().forEach(OrderClientExample::print);
    }

    private static void print(Order order) {
        System.out.printf("Order [id=%s, products=%s]%n", order.getId(), order.getProducts());
    }


}
