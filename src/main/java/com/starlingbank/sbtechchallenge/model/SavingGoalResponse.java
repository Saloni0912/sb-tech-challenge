package com.starlingbank.sbtechchallenge.model;

import java.util.List;

public class SavingGoalResponse {

    private String transferUid;
    private Boolean success;
    private List<Error> errors;

    public String getTransferUid() {
        return transferUid;
    }

    public void setTransferUid(String transferUid) {
        this.transferUid = transferUid;
    }

    public Boolean getSuccess() {
        return success;
    }

    public void setSuccess(Boolean success) {
        this.success = success;
    }

    public List<Error> getErrors(){
        return errors;
    }

    public void setErrors(List<Error> errors){
       this.errors=errors;
    }

}
