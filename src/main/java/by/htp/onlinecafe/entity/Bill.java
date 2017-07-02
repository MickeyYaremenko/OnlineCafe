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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Bill bill = (Bill) o;

        if (orderID != bill.orderID) return false;
        return sum != null ? sum.equals(bill.sum) : bill.sum == null;
    }

    @Override
    public int hashCode() {
        int result = orderID;
        result = 31 * result + (sum != null ? sum.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Bill{" +
                "orderID=" + orderID +
                ", sum=" + sum +
                '}';
    }
}
