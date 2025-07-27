package net.mihussain.ems.exception;

import java.time.LocalDateTime;
import java.util.Date;

public class ExceptionMessage {

    private String message;

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public LocalDateTime getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(LocalDateTime timestamp) {
        this.timestamp = timestamp;
    }

    public ExceptionMessage() {
    }

    private String description;
    private String path;
    private LocalDateTime timestamp;

    public ExceptionMessage(String message, String description, String path, LocalDateTime timestamp) {
        this.message = message;
        this.description = description;
        this.path = path;
        this.timestamp = timestamp;
    }
}
