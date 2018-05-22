package lt.vu.usecases.alternatives;

import javax.enterprise.inject.Alternative;
import javax.enterprise.inject.Specializes;

public class SecurePaypalPayment extends PaypalPayment {

    public String securePaymentProcess(){
        return "Secure payment! No personal information is getting stored in database for your safety :)";
    }

    @Override
    public String getPaymentType() {
        return "Secure Paypal Payment Processing! Email address to send money: eshop-secure@gmail.com";
    }

    @Override
    public double commissionFee(double cost, int vnt) {
        return super.commissionFee(cost, vnt + 10);
    }
}
