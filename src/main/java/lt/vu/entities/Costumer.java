package lt.vu.entities;

import org.apache.johnzon.mapper.JohnzonIgnore;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.util.Objects;
import java.util.Set;


@Entity
@Table(name = "COSTUMER")
@NamedQueries({
        @NamedQuery(name = "AllCustomers", query = "select a from Costumer a")
})
public class Costumer {
    @Id
    private Integer personalCode;

    @Size(max = 50)
    @Column(name = "NAME")
    private String name;

    @Size(max = 50)
    @Column(name = "SURNAME")
    private String surname;

    @JohnzonIgnore
    @OneToMany(cascade=CascadeType.ALL, mappedBy="costumer")
    private Set<Order> order;


    public Integer getPersonalCode() {
        return personalCode;
    }

    public void setPersonalCode(Integer personalCode) {
        this.personalCode = personalCode;
    }

    public Set<Order> getOrder() {
        return order;
    }

    public void setOrder(Set<Order> order) {
        this.order = order;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    @Override
    public boolean equals(Object p) {
        if (this == p) return true;
        if (p == null || getClass() != p.getClass()) return false;
        Costumer costumer = (Costumer) p;
        return Objects.equals(name, costumer.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }
}
