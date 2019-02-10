package io.avand.payment.service.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.io.Serializable;

public class ZarinpalVerifyResponseDTO implements Serializable {
    @JsonProperty("Status")
    private Integer status;
    @JsonProperty("RefID")
    private String refId;

    public ZarinpalVerifyResponseDTO() {
    }

    public Integer getStatus() {
        return this.status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getRefId() {
        return this.refId;
    }

    public void setRefId(String refId) {
        this.refId = refId;
    }

    public String toString() {
        return "ZarinpalVerifyResponseDTO{status=" + this.status + ", refId='" + this.refId + '\'' + '}';
    }
}
