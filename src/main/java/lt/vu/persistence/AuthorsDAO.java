package lt.vu.persistence;

import lt.vu.entities.Author;

import javax.enterprise.context.ApplicationScoped;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@ApplicationScoped
public class AuthorsDAO {
    @PersistenceContext
    private EntityManager em;

    public List<Author> loadAll() {
        return em.createNamedQuery("Author.findAll", Author.class).getResultList();
    }


    public Author findOne(Integer id) {
        return em.find(Author.class, id);
    }

    public void save(Author author) {
        this.em.persist(author);
    }
}