package ua.ithillel.soap.server.order.repository;

import ua.ithillel.soap.server.order.entity.Order;
import ua.ithillel.soap.server.order.entity.Product;

import java.util.*;
import java.util.stream.Collectors;

public class InMemoryOrderRepository implements OrderRepository {
    private final Map<String, Order> orders;

    public InMemoryOrderRepository() {
        orders = new HashMap<>();
    }

    public InMemoryOrderRepository(List<Order> orders) {
        this.orders = new HashMap<>();
        orders.forEach(order -> this.orders.put(order.getId(), order));
    }

    public List<Order> findAll() {
        return new ArrayList<>(orders.values());
    }

    public Order findById(String id) {
        return orders.get(id);
    }

    public Order create(List<Product> products) {
        var id = UUID.randomUUID().toString();
        var order = new Order(id, products);
        orders.put(id, order);
        return order;
    }

    public Order delete(String id) {
        return orders.remove(id);
    }

    public Order update(String id, List<Product> products) {
        if (orders.containsKey(id)) {
            var order = new Order(id, products);
            orders.put(id, order);
            return order;
        }
        return null;
    }
}
