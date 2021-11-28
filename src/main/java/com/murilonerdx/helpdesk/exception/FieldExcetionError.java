package com.murilonerdx.helpdesk.exception;

import java.io.Serializable;
import java.util.Date;

public class FieldExcetionError implements Serializable {

    private Date timestamp;
    private String message;
    private String details;

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

}
