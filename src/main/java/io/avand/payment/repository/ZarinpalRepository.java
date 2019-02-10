package io.avand.payment.repository;

import io.avand.payment.service.dto.ZarinpalResponseDTO;
import io.avand.payment.service.dto.ZarinpalVerifyResponseDTO;

public interface ZarinpalRepository {
    ZarinpalResponseDTO createPaymentLink(Long var1, String var2);

    ZarinpalVerifyResponseDTO verifyPayment(Long var1, String var2);
}
