package com.murilonerdx.helpdesk.exception;

import org.springframework.validation.BindingResult;

import java.io.Serializable;
import java.util.*;

public class FieldExcetionError implements Serializable {

    private Date timestamp;
    private String message;
    private String details;

    List<FieldMessage> errors = new ArrayList<>();

    public FieldExcetionError(Date timestamp, String message, String details) {
        super();
        this.timestamp = timestamp;
        this.message = message;
        this.details = details;
    }

    public Date getTimestamp() {
        return timestamp;
    }

    public String getMessage() {
        return message;
    }

    public String getDetails() {
        return details;
    }

    public void setTimestamp(Date timestamp) {
        this.timestamp = timestamp;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public void setDetails(String details) {
        this.details = details;
    }

    public List<FieldMessage> getErrors() {
        return errors;
    }

    public void setErrors(List<FieldMessage> errors) {
        this.errors = errors;
    }
}
