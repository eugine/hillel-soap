package ua.ithillel.soap.server.order;

import java.util.ArrayList;
import java.util.List;

public class OrderRepository {

    private final List<Order> db = new ArrayList<>();

    public OrderRepository(List<Order> initial) {
        db.addAll(initial);
    }

    public List<Order> findAll() {
        return new ArrayList<>(db);
    }

    public Order findById(int id) {
        return db.stream()
                .filter(order -> order.getId() == id)
                .findFirst()
                .orElseThrow();
    }

    public void save(Order order) {
        db.add(order);
    }
}
