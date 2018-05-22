package lt.vu.usecases;

import lt.vu.entities.Author;
import lt.vu.persistence.AuthorsDAO;

import javax.annotation.PostConstruct;
import javax.ejb.Stateless;
import javax.enterprise.inject.Model;
import javax.inject.Inject;
import javax.inject.Named;
import javax.transaction.Transactional;
import java.util.List;

// CDI container
// @Model: (=@RequestScoped + @Named) directly exposes the backing bean into JSF 2 (or JSP)
// From presentation to backend
// CDI helps to bridge a known "gap" between the enterprise tier (EJB objects) and the web tier.
//@Named annotation is a Dependency Injection For Java annotation that is used to associate a name with the bean.
// Because there is no name specified as an argument to the annotation, the name of the bean will be the name of
// the JavaBean with its first letter made lowercase, that is, clock. @Inject annotation in  is a CDI annotation
// that is used to identify a dependency injection point, that is, a point at which a dependency on a Java class or interface can be injected
// @Named
// @Stateless

@Model
public class Authors {
    @Inject
    private AuthorsDAO authorsDAO;
    private List<Author> allAuthors;

    //Default initial values could be set here or inside the Author model - which is better?
    private Author newAuthor = new Author();


    @PostConstruct
    public void init() {
        this.loadAuthors();
    }


    @Transactional
    public String createNewAuthor() {
        authorsDAO.save(newAuthor);
        return "index?faces-redirect=true";
    }

    private void loadAuthors() {
        this.allAuthors = authorsDAO.loadAll();
    }


    public List<Author> getAllAuthors() {
        return allAuthors;
    }

    public String sayHello() {
        return "Hello World";
    }


    public Author getNewAuthor() {
        return newAuthor;
    }

    public void setNewAuthor(Author newAuthor) {
        this.newAuthor = newAuthor;
    }
}

