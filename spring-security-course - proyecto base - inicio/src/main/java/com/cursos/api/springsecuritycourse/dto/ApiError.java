package com.cursos.api.springsecuritycourse.dto;

import java.io.Serializable;
import java.time.LocalDateTime;

public class ApiError implements Serializable {
    private String backendMessage;
    private String message;
    private LocalDateTime timeStamp;

    public String getBackendMessage() {
        return backendMessage;
    }

    public void setBackendMessage(String backendMessage) {
        this.backendMessage = backendMessage;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public LocalDateTime getTimeStamp() {
        return timeStamp;
    }

    public void setTimeStamp(LocalDateTime timeStamp) {
        this.timeStamp = timeStamp;
    }
}
