package com.pluralsight.models.addedExtras;

import com.pluralsight.models.Order;

public abstract class AddOn extends Order {
    // this should be anything extras we need to pay for like
    String name;

    public AddOn(int size, double price, String name) {
        super(size, price);
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
