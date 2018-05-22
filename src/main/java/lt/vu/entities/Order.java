package lt.vu.entities;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.util.Date;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@Entity
@Table(name = "ORDERS")
@NamedQueries({
        @NamedQuery(name = "AllOrders", query = "select a from Order a")
})
public class Order {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;


    @Size(max = 50)
    @Column(name = "ADDRESS")

    private String address;

    @Column(name = "DELIVERY_DATE")
    private Date deliveryDate;


    @ManyToOne(cascade=CascadeType.ALL)
    @JoinColumn(name="COSTUMER_FK")
    private Costumer costumer;


    @Version
    @Column(name = "VERSION")
    private Integer optLockVersion;



    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Costumer getCostumer() {
        return costumer;
    }

    public void setCostumer(Costumer costumer) {
        this.costumer = costumer;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Date getDeliveryDate() {
        return deliveryDate;
    }

    public void setDeliveryDate(Date deliveryDate) {
        this.deliveryDate = deliveryDate;
    }


    @Override
    public boolean equals(Object p) {
        if (this == p) return true;
        if (p == null || getClass() != p.getClass()) return false;
        Order manufacturer = (Order) p;
        return Objects.equals(address, manufacturer.address);
    }

    @Override
    public int hashCode() {
        return Objects.hash(address);
    }

    public Integer getOptLockVersion() {
        return optLockVersion;
    }

    public void setOptLockVersion(Integer optLockVersion) {
        this.optLockVersion = optLockVersion;
    }

}