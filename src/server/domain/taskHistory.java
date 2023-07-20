package server.domain;

import java.time.LocalDateTime;

public class TaskHistory {

    private String timestamp;
    private String oldStatus;
    private String newStatus;
    private String movedBy;

    public TaskHistory() {
        // Default constructor
    }

    public TaskHistory(LocalDateTime timestamp, String oldStatus, String newStatus, String movedBy) {
        this.timestamp = timestamp.toString();
        this.oldStatus = oldStatus;
        this.newStatus = newStatus;
        this.movedBy = movedBy;
    }

    // Getters and Setters for the properties
    public String getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(String timestamp) {
        this.timestamp = timestamp;
    }

    public String getOldStatus() {
        return oldStatus;
    }

    public void setOldStatus(String oldStatus) {
        this.oldStatus = oldStatus;
    }

    public String getNewStatus() {
        return newStatus;
    }

    public void setNewStatus(String newStatus) {
        this.newStatus = newStatus;
    }

    public String getMovedBy() {
        return movedBy;
    }

    public void setMovedBy(String movedBy) {
        this.movedBy = movedBy;
    }
}
