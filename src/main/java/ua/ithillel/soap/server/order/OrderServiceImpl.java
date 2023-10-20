package ua.ithillel.soap.server.order;

import jakarta.jws.WebService;
import lombok.RequiredArgsConstructor;

import java.util.List;

@RequiredArgsConstructor
@WebService(endpointInterface = "ua.ithillel.soap.server.order.OrderService")
public class OrderServiceImpl implements OrderService {

    private final OrderRepository repository;

    @Override
    public List<Order> getOrders() {
        return repository.findAll();
    }

    @Override
    public Order getOrderById(int id) {
        return repository.findById(id);
    }
}
