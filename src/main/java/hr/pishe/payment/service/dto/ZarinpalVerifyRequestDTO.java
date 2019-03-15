package hr.pishe.payment.service.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.io.Serializable;

public class ZarinpalVerifyRequestDTO implements Serializable {
    @JsonProperty("Authority")
    private String authority;
    @JsonProperty("Amount")
    private Long amount;
    @JsonProperty("MerchantID")
    private String merchantId;

    public ZarinpalVerifyRequestDTO() {
    }

    public String getAuthority() {
        return this.authority;
    }

    public void setAuthority(String authority) {
        this.authority = authority;
    }

    public Long getAmount() {
        return this.amount;
    }

    public void setAmount(Long amount) {
        this.amount = amount;
    }

    public String getMerchantId() {
        return this.merchantId;
    }

    public void setMerchantId(String merchantId) {
        this.merchantId = merchantId;
    }

    public String toString() {
        return "ZarinpalVerifyRequestDTO{authority='" + this.authority + '\'' + ", amount=" + this.amount + ", merchantId='" + this.merchantId + '\'' + '}';
    }
}
