package io.avand.payment.service;

import io.avand.payment.service.dto.PaymentDTO;

public interface PaymentService {
    PaymentDTO createPaymentLink(Long var1, String var2);

    String verifyPayment(Long var1, String var2);
}
