package ua.ithillel.soap.server.order;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

public class InMemoryOrderRepository implements OrderRepository {
    private static final Random random = new Random();

    private final List<Order> orders;

    public InMemoryOrderRepository() {
        this.orders = new ArrayList<>();
    }

    public InMemoryOrderRepository(List<Order> orders) {
        this.orders = new ArrayList<>(orders);
    }

    @Override
    public List<Order> findAll() {
        return new ArrayList<>(orders);
    }

    @Override
    public Order findById(int id) {
        return orders.stream()
                .filter(order -> order.getId() == id)
                .findFirst()
                .orElse(null);
    }

    @Override
    public Order create(List<Product> products) {
        var id =random.nextInt(10_000);
        Order order = new Order(id, products);
        orders.add(order);
        return order;
    }
}
