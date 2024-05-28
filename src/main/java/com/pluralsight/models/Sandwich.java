package com.pluralsight.models;

import com.pluralsight.models.addedExtras.AddOn;
import com.pluralsight.models.toppings.Topping;

import java.util.HashSet;

public class Sandwich extends Order{
    String breadChoice;
    HashSet<Topping> toppings;
    //HashSet<AddOn> addOns;
    public Sandwich(int size, String breadChoice, HashSet<Topping> toppings) {
        super(
                size,
                switch (size) {
                    case 1 -> 5.50;
                    case 2 -> 7.00;
                    case 3 -> 8.50;
                    default -> throw new IllegalStateException("Unexpected value: " + size);
                }
        );
        this.breadChoice = breadChoice;
        this.toppings = toppings;
    }

    public String getBreadChoice() {
        return breadChoice;
    }

    public HashSet<Topping> getToppings() {
        return toppings;
    }

   public double getTotalPrice(){
        return 0;
    }
}
