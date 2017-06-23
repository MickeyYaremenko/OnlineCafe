package by.htp.onlinecafe.entity;

import java.time.LocalDateTime;
import java.util.List;

/**
 * Created by Mike Yaremenko on 17.06.2017.
 */
public class Order {
    private int id;
    private int userID;
    private List<MenuItem> items;
    private LocalDateTime dateTime;
    private Status status;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getUserID() {
        return userID;
    }

    public void setUserID(int userID) {
        this.userID = userID;
    }

    public List<MenuItem> getItems() {
        return items;
    }

    public void setItems(List<MenuItem> items) {
        this.items = items;
    }

    public LocalDateTime getDateTime() {
        return dateTime;
    }

    public void setDateTime(LocalDateTime dateTime) {
        this.dateTime = dateTime;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }


    enum Status {
        ON_APPROVAL,
        COOKING,
        READY
    }

}
