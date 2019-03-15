package hr.pishe.payment.service.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.io.Serializable;

public class ZarinpalRequestDTO implements Serializable {
    @JsonProperty("MerchantID")
    private String merchantId;
    @JsonProperty("Amount")
    private Long amount;
    @JsonProperty("CallbackURL")
    private String callbackURL;
    @JsonProperty("Description")
    private String description;

    public ZarinpalRequestDTO() {
    }

    public String getMerchantId() {
        return this.merchantId;
    }

    public void setMerchantId(String merchantId) {
        this.merchantId = merchantId;
    }

    public Long getAmount() {
        return this.amount;
    }

    public void setAmount(Long amount) {
        this.amount = amount;
    }

    public String getCallbackURL() {
        return this.callbackURL;
    }

    public void setCallbackURL(String callbackURL) {
        this.callbackURL = callbackURL;
    }

    public String getDescription() {
        return this.description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String toString() {
        return "ZarinpalRequestDTO{merchantId='" + this.merchantId + '\'' + ", amount=" + this.amount + ", callbackURL='" + this.callbackURL + '\'' + ", description='" + this.description + '\'' + '}';
    }
}
