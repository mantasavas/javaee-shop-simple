package lt.vu.usecases;

import lt.vu.usecases.SpecializesTestingFunc.*;
import lt.vu.usecases.alternatives.PaymentProcessor;

import javax.annotation.PostConstruct;
import javax.enterprise.inject.Model;
import javax.inject.Inject;

@Model
public class ProcessPayment {
    @Inject
    private PaymentProcessor paymentProcessor;

    @Inject @CreditCardPayment
    Service service;

    private String processingMessage;

    private double totalSum;

    @PostConstruct
    public void init() {
        System.out.println( "Inserted into service bean: " + service.getClass().getName());
        processingMessage = paymentProcessor.getPaymentType();
        totalSum = paymentProcessor.commissionFee(20, 3);
    }

    public String getProcessingMessage() {
        return processingMessage;
    }

    public void setProcessingMessage(String processingMessage) {
        this.processingMessage = processingMessage;
    }

    public double getTotalSum() {
        return totalSum;
    }

    public void setTotalSum(double totalSum) {
        this.totalSum = totalSum;
    }
}
