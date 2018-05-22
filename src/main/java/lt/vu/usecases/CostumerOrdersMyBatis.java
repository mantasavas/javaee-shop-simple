package lt.vu.usecases;

import lt.vu.mybatis.model.Author;
import lt.vu.mybatis.model.Costumer;
import lt.vu.entities.Order;
import lt.vu.mybatis.dao.CostumerMapper;
import lt.vu.mybatis.dao.OrdersMapper;
import lt.vu.persistence.CostumerDAO;
import lt.vu.persistence.OrderDAO;

import javax.annotation.PostConstruct;
import javax.enterprise.inject.Model;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.transaction.Transactional;
import java.util.Date;
import java.util.List;
import java.util.Map;

@Model
public class CostumerOrdersMyBatis {

    @Inject
    private OrdersMapper orderDAO;

    @Inject
    private CostumerMapper costumerDAO;


    private List<Costumer> allCostumers;

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
            findedCostumer = costumerDAO.selectByPrimaryKey(costumerId);
        }catch (Exception ex){
            System.out.println("Couldn't find any parameters! " + ex.toString());
        }

        allCostumers = costumerDAO.selectAll();
    }

    public String hello(){

        return "Hellow World";
    }

    /*
    @Transactional
    @SuppressWarnings("Duplicates")
    public String createOrder() {

        newOrder.setCostumer(findedCostumer);
        orderDAO.save(newOrder);

        return "orderList";
    }


    // Loads all data to db
    @SuppressWarnings("Duplicates")
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
    */

    public List<Costumer> getAllCostumers() {
        return allCostumers;
    }

    public void setAllCostumers(List<Costumer> allCostumers) {
        this.allCostumers = allCostumers;
    }

}
