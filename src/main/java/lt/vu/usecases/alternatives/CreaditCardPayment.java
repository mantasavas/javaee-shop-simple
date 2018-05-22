package lt.vu.usecases.alternatives;

import javax.enterprise.inject.Alternative;


public class CreaditCardPayment implements PaymentProcessor {

    // Identifying payment type. Two payment types available: Credit card and Paypal
    @Override
    public String getPaymentType() {
        return "Creadit Card Payment Processing! Please transfer to bank account: LT15151242154720";
    }

    // Calculating commission fee of products ordered. Commission fee is proportional to cost and amount
    @Override
    public double commissionFee(double cost, int vnt) {
        System.out.println("Calculating commission fee for Credit card payment processing!");
        if (cost > 20) {
            return cost * vnt + 0.12;
        }else if (vnt > 5) {
            return cost * vnt + 0.50;
        }else if (cost <= 20) {
            return cost * vnt + 0.20;
        }else{
            return cost * vnt + 0.30;
        }
    }
}
