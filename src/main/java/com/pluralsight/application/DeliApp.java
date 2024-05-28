package com.pluralsight.application;

import com.pluralsight.models.*;
import com.pluralsight.models.addedExtras.*;
import com.pluralsight.models.toppings.*;
import com.pluralsight.ui.UserInterface;
import com.pluralsight.ui.enumerations.*;

import java.util.HashSet;

public class DeliApp {
    private Customer customer = new Customer();
    private UserInterface ui = new UserInterface();

    private void err() {
        System.out.println("Invalid input please enter correct response. ");
    }

    public void run() {
        OrderChoice choice;
        while (true) {
            choice = ui.getMainMenu();
            switch (choice) {
                case NewOrder -> handleNewOrder();
                case Exit -> System.exit(0);
            };
        }
    }

    private void handleNewOrder() {
        OrderChoice choice = ui.getOrderScreen();
        switch (choice) {
            case AddSandwich -> customer.addToOrder(handleNewSandwich());
            case AddDrink -> customer.addToOrder(handleNewDrink());
            case AddChips -> customer.addToOrder(handleNewChips());
            case Checkout -> handleCheckout();
            case CancelOrder -> handleCancelOrder();
        }
    }

    // TOO BIG: Separate this into different methods
    private Sandwich handleNewSandwich() {
        // getSandwichSize
        int size = handleSize();
        // getSandwichScreen
        String bread = handleBread();

        PremiumTopping meat = handleMeatChoice();
        PremiumTopping cheese = handleCheeseChoice();
        HashSet<Topping> regularToppings = handleRegularToppings();
        HashSet<Topping> sauces = handleSauces();
        HashSet<Topping> sides = handleSides();
        // getSauces

        HashSet<Topping> allToppings = new HashSet<>();
        allToppings.add(meat);
        allToppings.add(cheese);
        allToppings.addAll(regularToppings);
        allToppings.addAll(sauces);
        allToppings.addAll(sides);

        return new Sandwich(size, bread, allToppings);
    }

    private int handleSize() {
        UserChoice choice = ui.getSandwichSize();
        return switch (choice) {
            case Small -> 1;
            case Medium -> 2;
            case Large -> 3;
            default -> throw new IllegalStateException("Unexpected value: " + choice);
        };
    }

    private String handleBread () {
        SandwichChoice sandwichChoice = ui.getSandwichScreen();
        return switch (sandwichChoice) {
            case White -> "White";
            case Wheat -> "Wheat";
            case Rye -> "Rye";
            case Wrap -> "Wrap";
            default -> throw new IllegalStateException("Unexpected value: " + sandwichChoice);
        };
    }
    private PremiumTopping handleCheeseChoice() {
        ToppingChoice choice = ui.getCheese();
        String cheese = "";
        switch (choice) {
            case American -> cheese = "American";
            case Provolone -> cheese = "Provolone";
            case Cheddar -> cheese = "Cheddar";
            case Swiss -> cheese = "Swiss";
        }
        // getIsExtra
        boolean isExtraCheese = ui.getIsExtra();

        return new PremiumTopping("Cheese", cheese, isExtraCheese);
    }
    private PremiumTopping handleMeatChoice() {
        ToppingChoice choice = ui.getMeat();
        String meat = "";
        switch (choice) {
            case Steak -> meat = "Steak";
            case Ham -> meat = "Ham";
            case Salami -> meat = "Salami";
            case RoastBeef -> meat = "Roast Beef";
            case Chicken -> meat = "Chicken";
            case Bacon -> meat = "Bacon";
        }
        // getIsExtra
        boolean isExtraMeat = ui.getIsExtra();
        return new PremiumTopping("Meat", meat, isExtraMeat);
    }

    private HashSet<Topping> handleRegularToppings() {
        HashSet<Topping> toppingSet = new HashSet<>();
        ToppingChoice toppingChoice;
        String regTopping = "";

        do {
            toppingChoice = ui.getRegularTopping();
            switch (toppingChoice) {
                case Lettuce -> regTopping = "Lettuce";
                case Peppers -> regTopping = "Peppers";
                case Onions -> regTopping = "Onions";
                case Tomatoes -> regTopping = "Tomatoes";
                case Jalapenos -> regTopping = "Jalapenos";
                case Cucumbers -> regTopping = "Cucumbers";
                case Pickles -> regTopping = "Pickles";
                case Guacamole -> regTopping = "Guacamole";
                case Mushrooms -> regTopping = "Mushrooms";
                case None -> regTopping = "";
                case All -> {
                    toppingSet.clear();
                    toppingSet.addAll(handleAllToppings());
                }
            }
            if (toppingChoice != ToppingChoice.None) toppingSet.add(new RegularTopping(regTopping));
        } while (
                ui.addMore() && toppingChoice != ToppingChoice.All && toppingChoice != ToppingChoice.None
        );
        return toppingSet;
    }
    private HashSet<RegularTopping> handleAllToppings() {
        HashSet<RegularTopping> regularToppings = new HashSet<>();
        regularToppings.add(new RegularTopping("Lettuce"));
        regularToppings.add(new RegularTopping("Peppers"));
        regularToppings.add(new RegularTopping("Onions"));
        regularToppings.add(new RegularTopping("Tomatoes"));
        regularToppings.add(new RegularTopping("Jalapenos"));
        regularToppings.add(new RegularTopping("Cucumbers"));
        regularToppings.add(new RegularTopping("Pickles"));
        regularToppings.add(new RegularTopping("Guacamole"));
        regularToppings.add(new RegularTopping("Mushrooms"));
        return regularToppings;
    }

    private HashSet<Topping> handleSauces() {
        HashSet<Topping> sauces = new HashSet<>();
        ToppingChoice choice;
        String sauce = "";
        do {
            choice = ui.getSauces();
            switch (choice) {
                case Mayo -> sauce = "Mayo";
                case Mustard -> sauce = "Mustard";
                case Ketchup -> sauce = "Ketchup";
                case Ranch -> sauce = "Ranch";
                case ThousandIslands -> sauce = "ThousandIslands";
                case Vinaigrette -> sauce = "Vinaigrette";
                case None -> sauce = "";
                case All -> {
                    sauces.clear();
                    sauces.addAll(handleAllSauces());
                }
            }
            if (choice != ToppingChoice.None) sauces.add(new RegularTopping(sauce));
        } while (
                ui.addMore() &&
                        choice != ToppingChoice.All &&
                        choice != ToppingChoice.None
        );
        return sauces;
    }
    private HashSet<RegularTopping> handleAllSauces() {
        HashSet<RegularTopping> sauces = new HashSet<>();
        sauces.add(new RegularTopping("Mayo"));
        sauces.add(new RegularTopping("Mustard"));
        sauces.add(new RegularTopping("Ketchup"));
        sauces.add(new RegularTopping("Ranch"));
        sauces.add(new RegularTopping("Thousand Islands"));
        sauces.add(new RegularTopping("Vinaigrette"));
        return sauces;
    }

    private HashSet<Topping> handleSides() {
        HashSet<Topping> sides = new HashSet<>();
        ToppingChoice choice;
        String side = "";
        // getSides
        do {
            choice = ui.getSides();
            switch (choice) {
                case AuJus -> side = "Au Jus";
                case Sauces -> side = "Sauces";
                case None -> side = "";
                case All -> {
                    sides.clear();
                    sides.add(new RegularTopping("Au Jus"));
                    sides.add(new RegularTopping("Sauces"));
                }
            }
            if (choice != ToppingChoice.None) sides.add(new RegularTopping(side));
        } while (
                ui.addMore() &&
                        choice != ToppingChoice.All &&
                        choice != ToppingChoice.None
        );
        return sides;
    }

    private Drink handleNewDrink() {
        return new Drink(handleSize());
    }

    private Chips handleNewChips() {
        return new Chips();
    }

    private void handleCheckout() {
    }

    private void handleCancelOrder() {
    }
}
