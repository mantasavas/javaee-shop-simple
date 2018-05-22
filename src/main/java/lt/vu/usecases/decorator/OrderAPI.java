package lt.vu.usecases.decorator;

import lt.vu.entities.Costumer;
import lt.vu.entities.Order;

import javax.transaction.Transactional;
import java.io.Serializable;

public interface OrderAPI {
    public Order updateAndFlush(Order order);
}
