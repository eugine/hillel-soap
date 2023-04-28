package ua.ithillel.soap.server.order;

import jakarta.jws.WebMethod;
import jakarta.jws.WebService;
import lombok.RequiredArgsConstructor;
import ua.ithillel.soap.server.order.entity.Order;
import ua.ithillel.soap.server.order.repository.OrderRepository;

import java.util.List;

@RequiredArgsConstructor
@WebService(endpointInterface = "ua.ithillel.soap.server.order.OrderService")
public class OrderServiceImpl implements OrderService {

    private final OrderRepository orderRepository;

    @Override
    @WebMethod
    public Order get(String id) {
        return orderRepository.findById(id);
    }

    @Override
    @WebMethod
    public List<Order> getAll() {
        return orderRepository.findAll();
    }
}
