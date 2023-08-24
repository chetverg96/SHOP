package org.example;

import java.util.List;

public class Order {
    private int orderId;
    private List<Product> items;
    private OrderStatus status;

    public Order(List<Product> items) {
        this.items = items;
        this.status = OrderStatus.NEW;

    }

    public List<Product> getItems() {
        return getItems();
    }

    public OrderStatus getStatus() {
        return status;
    }

    public int getOrderId() {
        return orderId;
    }

    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }


    public void setStatus(OrderStatus status) {
        this.status = status;
    }


}
