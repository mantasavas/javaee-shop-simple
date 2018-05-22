package lt.vu.usecases;

import lt.vu.entities.Author;
import lt.vu.entities.Book;
import lt.vu.persistence.AuthorsDAO;
import lt.vu.persistence.BooksDAO;

import javax.annotation.PostConstruct;
import javax.enterprise.inject.Model;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.transaction.Transactional;
import java.util.Map;

@Model
public class BooksForAuthor {

    private Author author;

    private Book newBook = new Book();

    @Inject
    private BooksDAO booksDAO;

    @Inject
    private AuthorsDAO authorsDAO;

    @PostConstruct
    public void init() {
        Map<String, String> requestParameters =
                FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap();
        Integer authorId = Integer.parseInt(requestParameters.get("authorId"));
        this.author = authorsDAO.findOne(authorId);
    }

    public Author getAuthor() {
        return author;
    }

    public void setAuthor(Author author) {
        this.author = author;
    }


    @Transactional
    public String createBook() {
        newBook.setAuthor(this.author);
        booksDAO.save(newBook);
        return "books?faces-redirect=true&authorId=" + this.author.getId();
    }

    public Book getNewBook() {
        return newBook;
    }

    public void setNewBook(Book newBook) {
        this.newBook = newBook;
    }
}