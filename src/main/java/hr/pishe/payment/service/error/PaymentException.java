package hr.pishe.payment.service.error;

public class PaymentException extends RuntimeException {
    public PaymentException(String message) {
        super(message);
    }
}
