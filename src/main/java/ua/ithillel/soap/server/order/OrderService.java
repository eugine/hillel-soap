package ua.ithillel.soap.server.order;

import jakarta.jws.WebMethod;
import jakarta.jws.WebService;

import java.util.List;

@WebService
public interface OrderService {

    @WebMethod
    List<Order> getAll();
    @WebMethod
    void add(Order order);

}
