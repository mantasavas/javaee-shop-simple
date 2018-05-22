package lt.vu.persistence;

import lt.vu.entities.Product;

import javax.enterprise.context.ApplicationScoped;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.List;

@ApplicationScoped
public class ProductsDAO {
    @PersistenceContext
    private EntityManager em;

    public List<Product> getAllProducts() {
        return em.createNamedQuery("GetAllProducts", Product.class).getResultList();
    }


    public Product findProduct(Integer id) {
        return em.find(Product.class, id);
    }

    @Transactional
    public void saveProduct(Product product) {
        this.em.merge(product);
    }
}
