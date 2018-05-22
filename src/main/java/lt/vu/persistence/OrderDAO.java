package lt.vu.persistence;

import lt.vu.entities.Author;
import lt.vu.entities.Manufacturer;
import lt.vu.entities.Order;
import lt.vu.usecases.decorator.OrderAPI;
import lt.vu.usecases.decorator.OrderLogInfo;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.inject.TransientReference;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.List;


@ApplicationScoped
public class OrderDAO implements OrderAPI {
    @PersistenceContext
    private EntityManager em;

    public List<Order> getAllOrders() {
        return em.createNamedQuery("AllOrders", Order.class).getResultList();
    }

    public Order findOne(Integer id) {
        return em.find(Order.class, id);
    }

    public void save(Order order) {
        this.em.merge(order);
    }


    public Order updateAndFlush(Order order) {
        Order managedOrder = this.em.merge(order);
        em.flush();
        return managedOrder;
    }
}
