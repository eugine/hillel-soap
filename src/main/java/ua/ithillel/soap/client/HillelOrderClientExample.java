package ua.ithillel.soap.client;

import lombok.SneakyThrows;
import ua.ithillel.soap.order.client.Order;
import ua.ithillel.soap.order.client.OrderServiceImplService;
import ua.ithillel.soap.order.client.Product;
import ua.ithillel.soap.server.client.EmployeeServiceImplService;

import java.net.URL;
import java.util.List;
import java.util.stream.Collectors;

public class HillelOrderClientExample {

    @SneakyThrows
    public static void main(String[] args) {
        var url = new URL("http://localhost:8080/orderService?wsdl");

        var service = new OrderServiceImplService(url);
        var proxy = service.getOrderServiceImplPort();

        System.out.println("get all: ");
        proxy.getAll().forEach(HillelOrderClientExample::printOrder);
    }

    private static void printOrder(Order order) {
        System.out.printf("{id=%s, products=%s}%n", order.getId(), toString(order.getProducts()));
    }

    private static String toString(List<Product> products) {
        return products.stream()
                .map(product -> String.format("{id=%s, name=%s, price=%s}", product.getId(), product.getName(), product.getPrice()))
                .collect(Collectors.joining(", ", "[", "]"));
    }
}
