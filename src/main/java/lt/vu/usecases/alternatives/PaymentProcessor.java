package lt.vu.usecases.alternatives;

public interface PaymentProcessor {
    String getPaymentType();
    double commissionFee(double cost, int vnt);
}
