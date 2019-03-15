package hr.pishe.payment.repository;

import hr.pishe.payment.service.dto.ZarinpalResponseDTO;
import hr.pishe.payment.service.dto.ZarinpalVerifyResponseDTO;

public interface ZarinpalRepository {
    ZarinpalResponseDTO createPaymentLink(Long var1, String var2);

    ZarinpalVerifyResponseDTO verifyPayment(Long var1, String var2);
}
