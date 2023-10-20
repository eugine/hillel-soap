package ua.ithillel.soap.server.order;

import jakarta.jws.WebMethod;
import jakarta.jws.WebService;

import java.util.List;

@WebService
public interface OrderService {
    @WebMethod
    List<Order> getOrders();

    @WebMethod
    Order getOrderById(int id);

}
