package hr.pishe.payment.repository.impl;

import hr.pishe.payment.service.dto.ZarinpalRequestDTO;
import hr.pishe.payment.service.dto.ZarinpalResponseDTO;
import hr.pishe.payment.service.dto.ZarinpalVerifyRequestDTO;
import hr.pishe.payment.service.dto.ZarinpalVerifyResponseDTO;
import hr.pishe.payment.service.error.PaymentException;
import hr.pishe.payment.config.AppConfig;
import hr.pishe.payment.repository.ZarinpalRepository;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;
import org.springframework.web.client.HttpStatusCodeException;
import org.springframework.web.client.RestTemplate;

@Repository
public class ZarinpalRepositoryImpl implements ZarinpalRepository {
    private final AppConfig appConfig;
    private static final String API_URL = "https://www.zarinpal.com/pg/rest/WebGate/";

    public ZarinpalRepositoryImpl(AppConfig appConfig) {
        this.appConfig = appConfig;
    }

    public ZarinpalResponseDTO createPaymentLink(Long amount, String description) {
        RestTemplate restTemplate = new RestTemplate();
        HttpHeaders headers = new HttpHeaders();
        headers.add("Accept", "application/json");
        headers.add("Content-Type", "application/json");
        headers.add("User-Agent", "ZarinPal Rest Api v1");
        if (this.appConfig.getMerchantId() != null && this.appConfig.getCallbackUrl() != null) {
            ZarinpalRequestDTO zarinpalRequestDTO = new ZarinpalRequestDTO();
            zarinpalRequestDTO.setAmount(amount);
            zarinpalRequestDTO.setDescription(description);
            zarinpalRequestDTO.setMerchantId(this.appConfig.getMerchantId());
            zarinpalRequestDTO.setCallbackURL(this.appConfig.getCallbackUrl());
            HttpEntity request = new HttpEntity(zarinpalRequestDTO, headers);

            try {
                ResponseEntity<ZarinpalResponseDTO> responseEntity = restTemplate.exchange("https://www.zarinpal.com/pg/rest/WebGate/PaymentRequest.json", HttpMethod.POST, request, ZarinpalResponseDTO.class, new Object[0]);
                if (responseEntity.getStatusCode() != HttpStatus.OK && responseEntity.getStatusCode() != HttpStatus.CREATED) {
                    throw new PaymentException("Payment Failed With Cause : " + responseEntity.getStatusCode());
                } else {
                    return (ZarinpalResponseDTO)responseEntity.getBody();
                }
            } catch (HttpStatusCodeException var8) {
                throw new PaymentException(var8.getResponseBodyAsString());
            }
        } else {
            throw new PaymentException("MerchantId or CallbackUrl Not Available");
        }
    }

    public ZarinpalVerifyResponseDTO verifyPayment(Long amount, String authority) {
        RestTemplate restTemplate = new RestTemplate();
        HttpHeaders headers = new HttpHeaders();
        headers.add("Accept", "application/json");
        headers.add("Content-Type", "application/json");
        headers.add("User-Agent", "ZarinPal Rest Api v1");
        if (this.appConfig.getMerchantId() != null) {
            ZarinpalVerifyRequestDTO zarinpalVerifyRequestDTO = new ZarinpalVerifyRequestDTO();
            zarinpalVerifyRequestDTO.setAmount(amount);
            zarinpalVerifyRequestDTO.setAuthority(authority);
            zarinpalVerifyRequestDTO.setMerchantId(this.appConfig.getMerchantId());
            HttpEntity request = new HttpEntity(zarinpalVerifyRequestDTO, headers);

            try {
                ResponseEntity<ZarinpalVerifyResponseDTO> responseEntity = restTemplate.exchange("https://www.zarinpal.com/pg/rest/WebGate/PaymentVerification.json", HttpMethod.POST, request, ZarinpalVerifyResponseDTO.class, new Object[0]);
                if (responseEntity.getStatusCode() != HttpStatus.OK && responseEntity.getStatusCode() != HttpStatus.CREATED) {
                    throw new PaymentException("Verify Failed With Clause : " + responseEntity.getStatusCode());
                } else {
                    return (ZarinpalVerifyResponseDTO)responseEntity.getBody();
                }
            } catch (HttpStatusCodeException var8) {
                throw new PaymentException(var8.getResponseBodyAsString());
            }
        } else {
            throw new PaymentException("MerchantId Not Available");
        }
    }
}
