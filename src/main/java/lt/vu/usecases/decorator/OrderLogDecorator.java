package lt.vu.usecases.decorator;

import lt.vu.entities.Costumer;
import lt.vu.entities.Order;
import lt.vu.entities.OrderLog;
import lt.vu.persistence.OrderDAO;
import lt.vu.persistence.OrderLogDAO;

import javax.decorator.Decorator;
import javax.decorator.Delegate;
import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.context.SessionScoped;
import javax.enterprise.inject.Any;
import javax.enterprise.inject.Model;
import javax.inject.Inject;
import javax.inject.Named;
import java.io.Serializable;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

@ApplicationScoped
@Decorator
public abstract class OrderLogDecorator implements OrderAPI {

    @Inject
    @Delegate
    @Any
    OrderAPI orderDao;

    @Inject
    OrderLogDAO orderLogDAO;

    // Logs information about made orders
    @Override
    public Order updateAndFlush(Order order) {
        System.out.println("======================= Decorator =========================");
        Date recordFromDate = new GregorianCalendar(2014, Calendar.FEBRUARY, 11).getTime();
        Date currentDateTime = new Date();
        OrderLog orderLog = new OrderLog();

        if(recordFromDate.before(order.getDeliveryDate())) {
            System.out.println("Yesssss record it!!!!!");
            try {
                InetAddress ip = InetAddress.getLocalHost();
                System.out.println("IP of my system is := " + ip.getHostAddress());
                System.out.println("Current time: " + currentDateTime);
                orderLog.setDeliveryDate(order.getDeliveryDate());
                orderLog.setIpAddress(ip.toString());
                orderLog.setOrderDate(currentDateTime);
                orderLogDAO.save(orderLog);

            }catch (UnknownHostException ex){
                System.out.println("Could not find local host! " + ex.toString());
            }
        }else
        {
            System.out.println("No don't record it!!!!");
        }
        return orderDao.updateAndFlush(order);
    }


    public OrderAPI getOrderDao() {
        return orderDao;
    }

    public void setOrderDao(OrderAPI orderDao) {
        this.orderDao = orderDao;
    }
}
