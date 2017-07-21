package by.htp.onlinecafe.entity;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Map;

public class Order implements Serializable{

    private static final long serialVersionUID = 1969306549259835195L;
    private int id;
    private int clientID;
    private Map<MenuItem, Integer> items;
    private LocalDateTime dateTime;
    private Status status;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getClientID() {
        return clientID;
    }

    public void setClientID(int clientID) {
        this.clientID = clientID;
    }

    public Map<MenuItem, Integer> getItems() {
        return items;
    }

    public void setItems(Map<MenuItem, Integer> items) {
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Order order = (Order) o;

        if (id != order.id) return false;
        if (clientID != order.clientID) return false;
        if (items != null ? !items.equals(order.items) : order.items != null) return false;
        if (dateTime != null ? !dateTime.equals(order.dateTime) : order.dateTime != null) return false;
        return status == order.status;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + clientID;
        result = 31 * result + (items != null ? items.hashCode() : 0);
        result = 31 * result + (dateTime != null ? dateTime.hashCode() : 0);
        result = 31 * result + (status != null ? status.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Order{" +
                "id=" + id +
                ", clientID=" + clientID +
                ", items=" + items +
                ", dateTime=" + dateTime +
                ", status=" + status +
                '}';
    }

    enum Status {
        ON_APPROVAL,
        COOKING,
        READY
    }

}
