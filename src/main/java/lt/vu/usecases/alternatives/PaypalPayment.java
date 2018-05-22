package lt.vu.usecases.alternatives;

import javax.enterprise.inject.Alternative;
import javax.enterprise.inject.Specializes;
import javax.inject.Named;

@StagingAlternative
public class PaypalPayment implements PaymentProcessor {

    // Identifying payment type. Two payment types available: Credit card and Paypal
    @Override
    public String getPaymentType() {
        return "Paypal Payment Processing! Email address to send money: eshop@gmail.com";
    }

    // Calculating commission fee of products ordered. Commission fee is proportional to cost and amount
    @Override
    public double commissionFee(double cost, int vnt) {
        System.out.println("Calculating commission fee for Paypal payment processing!");
        if (cost > 5) {
            return cost * vnt + 0.10;
        }else if (vnt > 50) {
            return cost * vnt + 0.18;
        }else if (cost <= 5) {
            return cost * vnt + 0.25;
        }else{
            return cost * vnt + 0.30;
        }
    }
}
