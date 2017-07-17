package by.htp.onlinecafe.entity.dto;

import by.htp.onlinecafe.entity.Client;
import by.htp.onlinecafe.entity.MenuItem;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Map;

public class OrderTO {

    private Integer id;
    private Client client;
    private Map<MenuItem, Integer> items;
    private LocalDateTime dateTime;
    private Status status;
    private BigDecimal sum;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
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

    public void countSum(){
        this.sum = BigDecimal.ZERO;
        for (Map.Entry<MenuItem, Integer> entry: this.getItems().entrySet()){
            this.sum = this.sum.add(entry.getKey().getPrice().multiply(new BigDecimal(entry.getValue())));
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        OrderTO orderTO = (OrderTO) o;

        if (getId() != orderTO.getId()) return false;
        if (getClient() != null ? !getClient().equals(orderTO.getClient()) : orderTO.getClient() != null)
            return false;
        if (getItems() != null ? !getItems().equals(orderTO.getItems()) : orderTO.getItems() != null) return false;
        if (getDateTime() != null ? !getDateTime().equals(orderTO.getDateTime()) : orderTO.getDateTime() != null)
            return false;
        if (getStatus() != orderTO.getStatus()) return false;
        return getSum() != null ? getSum().equals(orderTO.getSum()) : orderTO.getSum() == null;
    }

    @Override
    public int hashCode() {
        int result = getId();
        result = 31 * result + (getClient() != null ? getClient().hashCode() : 0);
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
                ", client=" + client +
                ", items=" + items +
                ", dateTime=" + dateTime +
                ", status=" + status +
                ", sum=" + sum +
                '}';
    }

    public enum Status {
        ON_APPROVAL,
        COOKING,
        READY,
        SERVED
    }
}
