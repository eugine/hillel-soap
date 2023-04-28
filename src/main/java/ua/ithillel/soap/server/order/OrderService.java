package ua.ithillel.soap.server.order;

import jakarta.jws.WebMethod;
import jakarta.jws.WebService;
import ua.ithillel.soap.server.order.entity.Order;

import java.util.List;

@WebService
public interface OrderService {

    @WebMethod
    Order get(String id);
    @WebMethod
    List<Order> getAll();
}
