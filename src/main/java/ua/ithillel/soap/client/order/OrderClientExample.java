package ua.ithillel.soap.client.order;

import ua.ithillel.soap.server.order.client.Order;
import ua.ithillel.soap.server.order.client.OrderServiceImplService;
import ua.ithillel.soap.server.order.client.Product;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.stream.Collectors;

public class OrderClientExample {
    public static void main(String[] args) throws MalformedURLException {
        var url = new URL("http://localhost:8080/orderService?wsdl");

        var service = new OrderServiceImplService(url);
        var port = service.getOrderServiceImplPort();

        port.getAll().forEach(OrderClientExample::printOrder);
    }

    private static void printOrder(Order order) {
        var products = order.getProducts().stream()
                .map(OrderClientExample::printProduct)
                .collect(Collectors.joining(", ", "{", "}"));
        System.out.printf("Order [id=%s, products=%s]%n", order.getId(), products);
    }

    private static String printProduct(Product product) {
        return String.format("Products [id=%s, name=%s, cost=%s]%n", product.getId(), product.getName(), product.getCost());
    }
}
