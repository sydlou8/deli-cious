package com.pluralsight.models.addedExtras;

public class Drink extends AddOn {
    public Drink(int size) {
        super(
                size,
                switch(size) {
                    case 1 -> 2.00;
                    case 2 -> 2.50;
                    case 3 -> 3.00;
                    default -> throw new IllegalStateException("Unexpected value: " + size);
                },
                "Drink"
        );
    }
}
