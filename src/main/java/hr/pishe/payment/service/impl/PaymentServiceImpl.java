package hr.pishe.payment.service.impl;

import hr.pishe.payment.service.dto.PaymentDTO;
import hr.pishe.payment.service.dto.ZarinpalVerifyResponseDTO;
import hr.pishe.payment.config.AppConfig;
import hr.pishe.payment.repository.ZarinpalRepository;
import hr.pishe.payment.service.PaymentService;
import hr.pishe.payment.service.dto.ZarinpalResponseDTO;
import hr.pishe.payment.service.error.PaymentException;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.stereotype.Service;

@Service
@EnableConfigurationProperties({AppConfig.class})
public class PaymentServiceImpl implements PaymentService {
    private final ZarinpalRepository zarinpalRepository;

    public PaymentServiceImpl(ZarinpalRepository zarinpalRepository) {
        this.zarinpalRepository = zarinpalRepository;
    }

    public PaymentDTO createPaymentLink(Long amount, String description) {
        ZarinpalResponseDTO zarinpalResponseDTO = this.zarinpalRepository.createPaymentLink(amount, description);
        if (zarinpalResponseDTO.getStatus().equals("100")) {
            PaymentDTO paymentDTO = new PaymentDTO();
            paymentDTO.setRefId(zarinpalResponseDTO.getAuthority());
            paymentDTO.setUrl("https://www.zarinpal.com/pg/pay/" + zarinpalResponseDTO.getAuthority());
            return paymentDTO;
        } else {
            throw new PaymentException("Payment Failed With Cause : " + zarinpalResponseDTO.getStatus());
        }
    }

    public String verifyPayment(Long amount, String authority) {
        ZarinpalVerifyResponseDTO zarinpalVerifyResponseDTO = this.zarinpalRepository.verifyPayment(amount, authority);
        if (zarinpalVerifyResponseDTO.getStatus() == 100) {
            return zarinpalVerifyResponseDTO.getRefId();
        } else {
            throw new PaymentException("Payment Verify Failed With Cause : " + zarinpalVerifyResponseDTO.getStatus());
        }
    }
}
