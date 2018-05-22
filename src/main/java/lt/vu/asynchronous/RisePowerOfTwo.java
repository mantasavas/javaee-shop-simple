package lt.vu.asynchronous;

import org.apache.deltaspike.core.api.future.Futureable;

import javax.ejb.AsyncResult;
import javax.enterprise.context.ApplicationScoped;
import java.io.Serializable;
import java.util.concurrent.Future;

@ApplicationScoped
public class RisePowerOfTwo implements Serializable {
    private static int count = 0;

    @Futureable
    public Future<Double> riseByPower(double number) {
        double risedNum = 0;
        try {
            Thread.sleep(3000); // Simulate intensive work
            risedNum = Math.pow(number, 2);
        } catch (InterruptedException e) {
            System.out.println("Exception rised while executing riseByPower: " + e.toString());
        }

        count++;
        return new AsyncResult<>(risedNum);
    }
}
