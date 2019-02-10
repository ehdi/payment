package io.avand.payment.service.error;

public class PaymentException extends RuntimeException {
    public PaymentException(String message) {
        super(message);
    }
}
