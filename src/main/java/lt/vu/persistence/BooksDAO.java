package lt.vu.persistence;

import lt.vu.entities.Book;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@ApplicationScoped
public class BooksDAO {
    @PersistenceContext(name = "BooksPU")
    private EntityManager em;

    private Book newBook = new Book();

    public void save(Book book) {
        this.em.persist(book);
    }
}
