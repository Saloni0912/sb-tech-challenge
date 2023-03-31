package com.starlingbank.sbtechchallenge.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import java.util.List;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "transferUid",
        "success"
})
public class SavingGoalResponse {

    @JsonProperty("transferUid")
    private String transferUid;
    @JsonProperty("success")
    private Boolean success;
    @JsonProperty("errors")
    private List<Error> errors;

    @JsonProperty("transferUid")
    public String getTransferUid() {
        return transferUid;
    }

    @JsonProperty("transferUid")
    public void setTransferUid(String transferUid) {
        this.transferUid = transferUid;
    }

    @JsonProperty("success")
    public Boolean getSuccess() {
        return success;
    }

    @JsonProperty("success")
    public void setSuccess(Boolean success) {
        this.success = success;
    }

    @JsonProperty("errors")
    public List<Error> getErrors(){
        return errors;
    }

    @JsonProperty("errors")
    public void setErrors(List<Error> errors){
       this.errors=errors;
    }

}
