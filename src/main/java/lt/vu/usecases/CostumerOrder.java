package lt.vu.usecases;

import lt.vu.entities.Costumer;
import lt.vu.entities.Manufacturer;
import lt.vu.entities.Order;
import lt.vu.entities.Product;
import lt.vu.persistence.CostumerDAO;
import lt.vu.persistence.ManufacturerDAO;
import lt.vu.persistence.OrderDAO;
import lt.vu.persistence.ProductsDAO;
import lt.vu.usecases.decorator.OrderAPI;

import javax.annotation.PostConstruct;
import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.inject.Model;
import javax.enterprise.inject.TransientReference;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.transaction.Transactional;
import java.text.SimpleDateFormat;
import java.util.*;

@Model
public class CostumerOrder {

    @Inject
    private CostumerDAO costumerDAO;
    @Inject
    private OrderDAO orderDAO;

    private Costumer findedCostumer;


    private Order newOrder = new Order();


    public Costumer getFindedCostumer() {
        return findedCostumer;
    }

    public void setFindedCostumer(Costumer findedCostumer) {
        this.findedCostumer = findedCostumer;
    }

    @PostConstruct
    @SuppressWarnings("Duplicates")
    public void init() {
        Map<String, String> requestParameters = FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap();
        try {
            Integer costumerId = Integer.parseInt(requestParameters.get("costumerPersonalCode"));
            findedCostumer = costumerDAO.findCostumer(costumerId);
        }catch (Exception ex){
            System.out.println("Couldn't find any parameters! " + ex.toString());
        }
    }


    @Transactional
    @SuppressWarnings("Duplicates")
    public String createOrder() {

        newOrder.setCostumer(findedCostumer);
        orderDAO.save(newOrder);

        return "paymentProcess";
    }


    // Loads all data to db

    @Transactional
    public String loadSampleCostumersAndOrders() {



        Costumer petrasCostumer = new Costumer();
        Costumer jonasCostumer = new Costumer();

        Order petrasOrder = new Order();
        Order petrasOrderSecond = new Order();
        Order jonasOrder = new Order();

        petrasCostumer.setName("Petras");
        petrasCostumer.setSurname("Petraitis");
        petrasCostumer.setPersonalCode(1254848);


        jonasCostumer.setName("Jonas");
        jonasCostumer.setSurname("Jonaitis");
        jonasCostumer.setPersonalCode(1254874);

        Date date = new Date();

        petrasOrder.setAddress("Vilniaurs raj. Pagiriai 10");
        petrasOrder.setDeliveryDate(date);
        petrasOrder.setCostumer(petrasCostumer);

        petrasOrderSecond.setAddress("Vilnius, karoliniskes 45");
        petrasOrderSecond.setDeliveryDate(date);
        petrasOrderSecond.setCostumer(petrasCostumer);

        jonasOrder.setAddress("Kaunas, konarskio g 20");
        jonasOrder.setDeliveryDate(date);
        jonasOrder.setCostumer(jonasCostumer);


        orderDAO.save(petrasOrder);
        orderDAO.save(petrasOrderSecond);
        orderDAO.save(jonasOrder);


        return "First time run, sample data loaded!";
    }


    public List<Costumer> getAllOrdersAndCostumers(){
        return costumerDAO.loadAll();
    }

    public Order getNewOrder() {
        return newOrder;
    }

    public void setNewOrder(Order newOrder) {
        this.newOrder = newOrder;
    }



}
