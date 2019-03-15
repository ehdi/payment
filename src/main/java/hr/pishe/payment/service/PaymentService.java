package hr.pishe.payment.service;

import hr.pishe.payment.service.dto.PaymentDTO;

public interface PaymentService {
    PaymentDTO createPaymentLink(Long var1, String var2);

    String verifyPayment(Long var1, String var2);
}
