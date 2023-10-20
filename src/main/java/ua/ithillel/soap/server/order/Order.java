package ua.ithillel.soap.server.order;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@Data
@AllArgsConstructor
public class Order {
    private int id;
    private List<Product> products;
}
