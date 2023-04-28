package ua.ithillel.soap.server.order.repository;

import ua.ithillel.soap.server.order.entity.Order;
import ua.ithillel.soap.server.order.entity.Product;

import java.util.List;

public interface OrderRepository {

    List<Order> findAll();
    Order findById(String id);
    Order create(List<Product> products);
    Order delete(String id);
    Order update(String id, List<Product> products);
}
