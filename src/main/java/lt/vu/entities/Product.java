package lt.vu.entities;

import javax.inject.Named;
import javax.persistence.*;
import javax.validation.constraints.Size;
import java.math.BigDecimal;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;


// All entities must have Entity and Id annotations at least to be valid
@Entity
// Tells that table Products fields are mapped to the class instance object
@Table(name = "PRODUCT")
@NamedQueries({
        @NamedQuery(name = "GetAllProducts", query = "select a from Product as a")
})
public class Product {

    public Product(){

    }

    @Id
    @Column(name = "BARCODE")
    private Integer barcode;

    @Column(name = "COST", columnDefinition="Decimal(10,2) default '0.00'")
    private BigDecimal cost;

    @Size(min=5, max = 90)
    @Column(name = "TITLE")
    private String title;

    @Size(max = 200)
    @Column(name = "DESCRIPTION")
    private String description;


    @ManyToMany(cascade=CascadeType.ALL)
    @JoinTable(name="manufacturer_product", joinColumns=@JoinColumn(name="PRODUCT_BARCODE"), inverseJoinColumns=@JoinColumn(name="MANUFACTURER_ID"))
    private Set<Manufacturer> manufacturers = new HashSet<>();

    @Version
    @Column(name = "VERSION")
    private Integer optLockVersion;


    public void setBarcode(Integer barcode) {
        this.barcode = barcode;
    }

    public void setCost(BigDecimal cost) {
        this.cost = cost;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void addManufacturer(Manufacturer manufacturer){
        manufacturers.add(manufacturer);
    }


    public Integer getBarcode() {
        return barcode;
    }

    public BigDecimal getCost() {
        return cost;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public Set<Manufacturer> getManufacturers() {
        return manufacturers;
    }

    public void setManufacturers(Set<Manufacturer> manufacturers) {
        this.manufacturers = manufacturers;
    }

    @Override
    public boolean equals(Object p) {
        if (this == p) return true;
        if (p == null || getClass() != p.getClass()) return false;
        Product product = (Product) p;
        return Objects.equals(title, product.title);
    }

    @Override
    public int hashCode() {
        return Objects.hash(title);
    }

}