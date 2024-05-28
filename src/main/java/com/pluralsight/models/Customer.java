package com.pluralsight.models;

import java.util.ArrayList;
import java.util.List;

public class Customer {
    private List<Order> order = new ArrayList<>();

    public void addToOrder(Order o) {
        order.add(o);
    }
    public void removeFromOrder(Order o) {
        order.remove(o);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        return sb.toString();
    }
}
