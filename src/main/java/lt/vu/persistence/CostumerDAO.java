package lt.vu.persistence;

import lt.vu.entities.Author;
import lt.vu.entities.Costumer;

import javax.enterprise.context.ApplicationScoped;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.beans.Customizer;
import java.util.List;

@ApplicationScoped
public class CostumerDAO {
    @PersistenceContext
    private EntityManager em;

    public List<Costumer> loadAll() {
        return em.createNamedQuery("AllCustomers", Costumer.class).getResultList();
    }


    public Costumer findCostumer(Integer id) {
        return em.find(Costumer.class, id);
    }

    public void saveCostumer(Costumer costumer) {
        this.em.merge(costumer);
    }
}
