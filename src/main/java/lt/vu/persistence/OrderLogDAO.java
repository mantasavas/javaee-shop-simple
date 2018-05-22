package lt.vu.persistence;

import lt.vu.entities.OrderLog;

import javax.enterprise.context.ApplicationScoped;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@ApplicationScoped
public class OrderLogDAO {
    @PersistenceContext
    private EntityManager em;

    public void save(OrderLog orderLog) {
        this.em.merge(orderLog);
    }
}
