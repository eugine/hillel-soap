package ua.ithillel.soap.server.order;

import jakarta.jws.WebService;

import java.util.List;

@WebService(endpointInterface = "ua.ithillel.soap.server.order.OrderService")
public class OrderServiceImpl implements OrderService {

    private final OrderRepository orderRepository;

    public OrderServiceImpl(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    @Override
    public List<Order> getAll() {
        return orderRepository.findAll();
    }

    @Override
    public void add(Order order) {
        orderRepository.save(order);
    }
}
