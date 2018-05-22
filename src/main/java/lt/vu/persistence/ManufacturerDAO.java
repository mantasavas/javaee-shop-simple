package lt.vu.persistence;

import lt.vu.entities.Manufacturer;
import lt.vu.entities.Product;

import javax.enterprise.context.ApplicationScoped;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.List;

@ApplicationScoped
public class ManufacturerDAO {
    @PersistenceContext
    private EntityManager em;

    public List<Manufacturer> getAllManufacturers() {
        return em.createNamedQuery("GetAllManufacturers", Manufacturer.class).getResultList();
    }

    public Manufacturer findManufacturer(Integer id) {
        return em.find(Manufacturer.class, id);
    }

    public void saveManufacturer(Manufacturer manufacturer) {
        this.em.merge(manufacturer);
    }
}
