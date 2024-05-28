package com.pluralsight.models.toppings;

public class RegularTopping implements Topping {
    // This should be any free toppings + sides + sauces
    private String type;
    public RegularTopping (String type) {
        this.type = type;
    }
    @Override
    public String getType() {
        return type;
    }
}
