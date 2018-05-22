package lt.vu.usecases.asynchronous;

import lt.vu.asynchronous.RisePowerOfTwo;

import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;
import java.io.Serializable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

@SessionScoped
@Named
public class FindPowerOfTwo implements Serializable {
    @Inject
    RisePowerOfTwo risePowerOfTwo;

    private double numberToBeRaised = 0;

    private Future<Double> result = null;

    public String isResultReady() throws ExecutionException, InterruptedException {
        if (result == null) {
            //result = risePowerOfTwo.riseByPower(5);
            System.out.println("User hasn't pressed a button!");
            return "Press button Calculate, to start asynchronous process!";

        } else {
            //double callResult = result.get(50000, TimeUnit.MILLISECONDS);
            if (result.isDone()) {

                try {
                    double callResult = result.get(2000, TimeUnit.MILLISECONDS);
                    result = null;
                    System.out.println("Calculations finished, result is ready! It's " + callResult);
                    return "Result is ready. Rised by power of 2: " + callResult;

                }catch (TimeoutException ex){
                    System.out.println("Timeout Exception Occurred! " + ex.toString());
                    return "Process took to long to process, try again next time!";
                }

            } else {
                System.out.println("Please wait, while calculations are being processed...");
                return "Please wait, calculations are being processed...";
            }
        }
    }

    // According to result, rise button is enabled or disabled
    public boolean areCalculationsDone() {
        return result != null && !result.isDone();
    }

    public void runCalculations()
    {
        if (result == null) {
            result = risePowerOfTwo.riseByPower(numberToBeRaised);
            System.out.println("Just called to start calculations! Has it finished: " + result.isDone());
        }
        else{
            System.out.println("Already initialized!");
        }
    }

    public double getNumberToBeRaised() {
        return numberToBeRaised;
    }

    public void setNumberToBeRaised(double numberToBeRaised) {
        this.numberToBeRaised = numberToBeRaised;
    }
}
