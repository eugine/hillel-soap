package ua.ithillel.soap.server.order;

import java.util.List;

public interface OrderRepository {
    public List<Order> findAll();

    public Order findById(int id);

    public Order create(List<Product> products);

}
