package lt.vu.entities;


import javax.persistence.*;
import javax.validation.constraints.Size;
import java.util.HashSet;
import java.util.List;
import java.util.Objects;
import java.util.Set;

@Entity
@Table(name = "MANUFACTURER")
@NamedQueries({
        @NamedQuery(name = "GetAllManufacturers", query = "select a from Manufacturer a")
})
public class Manufacturer {

    public Manufacturer(){}

    @Id
    @Column(name = "ID")
    private Integer id;

    @Size(max = 60)
    @Column(name = "NAME")
    private String name;

    @Size(max = 50)
    @Column(name = "LOCATION")

    private String location;

    @Size(max = 200)
    @Column(name = "DESCRIPTION")
    private String description;

    // mapped by need Products to have a field manufacturers
    @ManyToMany(cascade=CascadeType.ALL, mappedBy="manufacturers")
    private Set<Product> products = new HashSet<>();

    public void addProduct(Product product){
        products.add(product);
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Set<Product> getProducts() {
        return products;
    }

    public void setProducts(Set<Product> products) {
        this.products = products;
    }


    @Override
    public boolean equals(Object p) {
        if (this == p) return true;
        if (p == null || getClass() != p.getClass()) return false;
        Manufacturer manufacturer = (Manufacturer) p;
        return Objects.equals(name, manufacturer.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }
}
