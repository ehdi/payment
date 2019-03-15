package hr.pishe.payment.service.dto;

import java.io.Serializable;

public class PaymentDTO implements Serializable {
    private String refId;
    private String url;

    public PaymentDTO() {
    }

    public String getRefId() {
        return this.refId;
    }

    public void setRefId(String refId) {
        this.refId = refId;
    }

    public String getUrl() {
        return this.url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String toString() {
        return "PaymentDTO{refId='" + this.refId + '\'' + ", url='" + this.url + '\'' + '}';
    }
}
