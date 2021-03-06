package hr.pishe.payment.service.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.io.Serializable;

public class ZarinpalResponseDTO implements Serializable {
    @JsonProperty("Authority")
    private String authority;
    @JsonProperty("Status")
    private String status;

    public ZarinpalResponseDTO() {
    }

    public String getAuthority() {
        return this.authority;
    }

    public void setAuthority(String authority) {
        this.authority = authority;
    }

    public String getStatus() {
        return this.status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String toString() {
        return "ZarinpalResponseDTO{authority='" + this.authority + '\'' + ", status='" + this.status + '\'' + '}';
    }
}
