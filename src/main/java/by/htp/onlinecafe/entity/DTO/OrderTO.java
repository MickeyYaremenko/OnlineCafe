package by.htp.onlinecafe.entity.DTO;

import by.htp.onlinecafe.entity.MenuItem;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Map;

public class OrderTO {

    private int id;
    private int clientID;
    private Map<MenuItem, Integer> items;
    private LocalDateTime dateTime;
    private Status status;
    private BigDecimal sum;

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

    public BigDecimal getSum() {
        return sum;
    }

    public void setSum(BigDecimal sum) {
        this.sum = sum;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        OrderTO orderTO = (OrderTO) o;

        if (getId() != orderTO.getId()) return false;
        if (getClientID() != orderTO.getClientID()) return false;
        if (getItems() != null ? !getItems().equals(orderTO.getItems()) : orderTO.getItems() != null) return false;
        if (getDateTime() != null ? !getDateTime().equals(orderTO.getDateTime()) : orderTO.getDateTime() != null)
            return false;
        if (getStatus() != orderTO.getStatus()) return false;
        return getSum() != null ? getSum().equals(orderTO.getSum()) : orderTO.getSum() == null;
    }

    @Override
    public int hashCode() {
        int result = getId();
        result = 31 * result + getClientID();
        result = 31 * result + (getItems() != null ? getItems().hashCode() : 0);
        result = 31 * result + (getDateTime() != null ? getDateTime().hashCode() : 0);
        result = 31 * result + (getStatus() != null ? getStatus().hashCode() : 0);
        result = 31 * result + (getSum() != null ? getSum().hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "OrderTO{" +
                "id=" + id +
                ", clientID=" + clientID +
                ", items=" + items +
                ", dateTime=" + dateTime +
                ", status=" + status +
                ", sum=" + sum +
                '}';
    }

    enum Status {
        ON_APPROVAL,
        COOKING,
        READY
    }
}
