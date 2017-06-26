package by.htp.onlinecafe.entity;

import java.math.BigDecimal;

public class Bill {
    private int orderID;
    private BigDecimal sum;

    public int getOrderID() {
        return orderID;
    }

    public void setOrderID(int orderID) {
        this.orderID = orderID;
    }

    public BigDecimal getSum() {
        return sum;
    }

    public void setSum(BigDecimal sum) {
        this.sum = sum;
    }
}
