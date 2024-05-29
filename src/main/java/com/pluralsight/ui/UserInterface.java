package com.pluralsight.ui;

import com.pluralsight.models.Customer;
import com.pluralsight.ui.enumerations.*;
import java.util.Scanner;

public class UserInterface {
    private Scanner userInput = new Scanner(System.in);

    private void err() {
        System.out.println("Invalid Choice. Try again.");
    }

    public OrderChoice getMainMenu() {
        while(true) {
            System.out.print(
                    "=".repeat(50) + "\n" +
                    " ".repeat(14) + "Welcome to DELI-cious!" + "\n" +
                    "=".repeat(50) + "\n" +
                    """
                    Please make a selection:
                    \t[1] - New Order
                    \t[0] - EXIT
                    """);
            try {
                System.out.print("Your Selection: ");
                int choice = Integer.parseInt(userInput.nextLine().strip());
                return switch (choice) {
                    case 1 -> OrderChoice.NewOrder;
                    case 0 -> OrderChoice.Exit;
                    default -> throw new IllegalStateException("Unexpected value: " + choice);
                };
            } catch (Exception _) {
                System.out.println("Invalid Choice: Try again.");
            }
        }
    }

    public OrderChoice getOrderScreen() {
        while(true) {
            System.out.print(
                    "=".repeat(50) + "\n" +
                    " ".repeat(20) + "Order Menu" + "\n" +
                    "=".repeat(50) + "\n" +
                    """
                    Please make a selection:
                    \t[1] - Add Sandwich
                    \t[2] - Add Drink
                    \t[3] - Add Chips
                    \t[4] - Checkout
                    \t[0] - Cancel Order
                    """);
            try {
                System.out.print("Your Selection: ");
                int choice = Integer.parseInt(userInput.nextLine().strip());
                return switch (choice) {
                    case 1 -> OrderChoice.AddSandwich;
                    case 2 -> OrderChoice.AddDrink;
                    case 3 -> OrderChoice.AddChips;
                    case 4 -> OrderChoice.Checkout;
                    case 0 -> OrderChoice.CancelOrder;
                    default -> throw new IllegalStateException("Unexpected value: " + choice);
                };
            } catch (Exception _) {
                err();
            }
        }
    }
    public SandwichChoice getSandwichScreen() {
        while(true) {
            System.out.print(
                    "=".repeat(50) + "\n" +
                    " ".repeat(15) + "Build Your Sandwich!" + "\n" +
                    "=".repeat(50) + "\n" +
                    """
                    Please make a BREAD selection:
                    \t[1] - White
                    \t[2] - Wheat
                    \t[3] - Rye
                    \t[4] - Wrap
                    """);
            try {
                System.out.print("Your Selection: ");
                int choice = Integer.parseInt(userInput.nextLine().strip());
                return switch (choice) {
                    case 1 -> SandwichChoice.White;
                    case 2 -> SandwichChoice.Wheat;
                    case 3 -> SandwichChoice.Rye;
                    case 4 -> SandwichChoice.Wrap;
                    default -> throw new IllegalStateException("Unexpected value: " + choice);
                };
            } catch (Exception _) {
                err();
            }
        }
    }
    public UserChoice getSandwichSize() {
        while(true) {
            System.out.print(
                    "=".repeat(50) + "\n" +
                    " ".repeat(15) + "Build Your Sandwich!" + "\n" +
                    "=".repeat(50) + "\n" +
                    """
                    Please make a SIZE selection:
                    \t[1] - Small
                    \t[2] - Medium
                    \t[3] - Large
                    """);
            try {
                System.out.print("Your Selection: ");
                int choice = Integer.parseInt(userInput.nextLine().strip());
                return switch (choice) {
                    case 1 -> UserChoice.Small;
                    case 2 -> UserChoice.Medium;
                    case 3 -> UserChoice.Large;
                    default -> throw new IllegalStateException("Unexpected value: " + choice);
                };
            } catch (Exception _) {
                err();
            }
        }
    }
    public boolean getIsToasted() {
        while (true){
            System.out.print(
                    """
                            Would you like your Sandwich Toasted:
                            \t[1] - Yes
                            \t[2] - No
                            """);
            try {
                System.out.print("Your Selection: ");
                int choice = Integer.parseInt(userInput.nextLine().strip());
                return switch (choice) {
                    case 1 -> true;
                    case 2 -> false;
                    default -> throw new IllegalStateException("Unexpected value: " + choice);
                };
            } catch (Exception _) {
                System.out.println("Invalid Choice: Try again.");
            }
        }
    }

    public ToppingChoice getRegularTopping() {
        while(true) {
            System.out.print(
                    "=".repeat(50) + "\n" +
                    " ".repeat(15) + "Build Your Sandwich!" + "\n" +
                    "=".repeat(50) + "\n" +
                    """
                    Please make a BREAD selection:
                    \t[1]  - Lettuce
                    \t[2]  - Peppers
                    \t[3]  - Onions
                    \t[4]  - Tomatoes
                    \t[5]  - Jalapenos
                    \t[6]  - Cucumbers
                    \t[7]  - Pickles
                    \t[8]  - Guacamole
                    \t[9]  - Mushrooms
                    \t[10] - None
                    \t[11] - All
                    """);
            try {
                System.out.print("Your Selection: ");
                int choice = Integer.parseInt(userInput.nextLine().strip());
                return switch (choice) {
                    case 1 -> ToppingChoice.Lettuce;
                    case 2 -> ToppingChoice.Peppers;
                    case 3 -> ToppingChoice.Onions;
                    case 4 -> ToppingChoice.Tomatoes;
                    case 5 -> ToppingChoice.Jalapenos;
                    case 6 -> ToppingChoice.Cucumbers;
                    case 7 -> ToppingChoice.Pickles;
                    case 8 -> ToppingChoice.Guacamole;
                    case 9 -> ToppingChoice.Mushrooms;
                    case 10 -> ToppingChoice.None;
                    case 11 -> ToppingChoice.All;
                    default -> throw new IllegalStateException("Unexpected value: " + choice);
                };
            } catch (Exception _) {
                System.out.println("Invalid Choice: Try again.");
            }
        }
    }
    public ToppingChoice getMeat() {
        while(true) {
            System.out.print(
                    "=".repeat(50) + "\n" +
                    " ".repeat(12) + "Build Your Sandwich: Meat!" + "\n" +
                    "=".repeat(50) + "\n" +
                    """
                    Please make a MEAT selection:
                    \t[1] - Steak
                    \t[2] - Ham
                    \t[3] - Salami
                    \t[4] - Roast Beef
                    \t[5] - Chicken
                    \t[6] - Bacon
                    """);
            try {
                System.out.print("Your Selection: ");
                int choice = Integer.parseInt(userInput.nextLine().strip());
                return switch (choice) {
                    case 1 -> ToppingChoice.Steak;
                    case 2 -> ToppingChoice.Ham;
                    case 3 -> ToppingChoice.Salami;
                    case 4 -> ToppingChoice.RoastBeef;
                    case 5 -> ToppingChoice.Chicken;
                    case 6 -> ToppingChoice.Bacon;
                    default -> throw new IllegalStateException("Unexpected value: " + choice);
                };
            } catch (Exception _) {
                System.out.println("Invalid Choice: Try again.");
            }
        }
    }
    public ToppingChoice getCheese() {
        while(true) {
            System.out.print(
                    "-".repeat(50) + "\n" +
                    " ".repeat(11) + "Build Your Sandwich: Cheese!" + "\n" +
                    "-".repeat(50) + "\n" +
                    """
                    Please make a CHEESE selection:
                    \t[1] - American
                    \t[2] - Provolone
                    \t[3] - Cheddar
                    \t[4] - Swiss
                    """);
            try {
                System.out.print("Your Selection: ");
                int choice = Integer.parseInt(userInput.nextLine().strip());
                return switch (choice) {
                    case 1 -> ToppingChoice.American;
                    case 2 -> ToppingChoice.Provolone;
                    case 3 -> ToppingChoice.Cheddar;
                    case 4 -> ToppingChoice.Swiss;
                    default -> throw new IllegalStateException("Unexpected value: " + choice);
                };
            } catch (Exception _) {
                System.out.println("Invalid Choice: Try again.");
            }
        }
    }
    public ToppingChoice getSauces() {
        while(true) {
            System.out.print(
                    "=".repeat(50) + "\n" +
                    " ".repeat(11) + "Build Your Sandwich: Sauces!" + "\n" +
                    "=".repeat(50) + "\n" +
                    """
                    Please make a SAUCE selection:
                    \t[1] - Mayo
                    \t[2] - Mustard
                    \t[3] - Ketchup
                    \t[4] - Ranch
                    \t[5] - Thousand Islands
                    \t[6] - Vinaigrette
                    \t[7] - None
                    \t[8] - All
                    """);
            try {
                System.out.print("Your Selection: ");
                int choice = Integer.parseInt(userInput.nextLine().strip());
                return switch (choice) {
                    case 1 -> ToppingChoice.Mayo;
                    case 2 -> ToppingChoice.Mustard;
                    case 3 -> ToppingChoice.Ketchup;
                    case 4 -> ToppingChoice.Ranch;
                    case 5 -> ToppingChoice.ThousandIslands;
                    case 6 -> ToppingChoice.Vinaigrette;
                    case 7 -> ToppingChoice.None;
                    case 8 -> ToppingChoice.All;
                    default -> throw new IllegalStateException("Unexpected value: " + choice);
                };
            } catch (Exception _) {
                System.out.println("Invalid Choice: Try again.");
            }
        }
    }
    public ToppingChoice getSides() {
        while(true) {
            System.out.print(
                    "-".repeat(50) + "\n" +
                    " ".repeat(13) + "Build Your Sandwich: Side!" + "\n" +
                    "-".repeat(50) + "\n" +
                    """
                    Please make a selection of what you want on the side:
                    \t[1] - Au Jus
                    \t[2] - Sauces
                    \t[3] - None
                    \t[4] - All
                    """);
            try {
                System.out.print("Your Selection: ");
                int choice = Integer.parseInt(userInput.nextLine().strip());
                return switch (choice) {
                    case 1 -> ToppingChoice.AuJus;
                    case 2 -> ToppingChoice.Sauces;
                    case 3 -> ToppingChoice.None;
                    case 4 -> ToppingChoice.All;
                    default -> throw new IllegalStateException("Unexpected value: " + choice);
                };
            } catch (Exception _) {
                System.out.println("Invalid Choice: Try again.");
            }
        }
    }

    public boolean getIsExtra() {
        while(true) {
            System.out.print(
                    """
                    Would you like extra:
                    \t[1] - Yes
                    \t[2] - No
                    """);
            try {
                System.out.print("Your Selection: ");
                int choice = Integer.parseInt(userInput.nextLine().strip());
                return choice == 1;
            } catch (Exception _) {
                System.out.println("Invalid Choice: Try again.");
            }
        }
    }
    public boolean addMore() {
        while(true) {
            System.out.print(
                    """
                    Would you like to add more toppings:
                    \t[1] - Yes
                    \t[2] - No
                    """);
            try {
                System.out.print("Your Selection: ");
                int choice = Integer.parseInt(userInput.nextLine().strip());
                return choice == 1;
            } catch (Exception _) {
                System.out.println("Invalid Choice: Try again.");
            }
        }
    }

    // add Drink Flavor
    public boolean getDrink() {
        while(true) {
            System.out.print(
                    "-".repeat(50) + "\n" +
                    " ".repeat(15) + "Any Drinks?"+ "\n" +
                    "-".repeat(50) + "\n" +
                    """
                    Would you like a Drink?
                    \t[1] - Yes
                    \t[2] - No
                    """
            );
            try {
                System.out.print("Your Selection: ");
                int choice = Integer.parseInt(userInput.nextLine().strip());
                return choice == 1;
            } catch (Exception _) {
                System.out.println("Invalid Choice: Try again.");
            }
        }
    }
    public UserChoice getDrinkSize() {
        while (true) {
            System.out.print(
                    """
                    \nWhat size?
                    \t[1] - Small
                    \t[2] - Medium
                    \t[3] - Large
                    """
            );
            try {
                System.out.print("Your Selection: ");
                int choice = Integer.parseInt(userInput.nextLine().strip());
                return switch (choice) {
                    case 1 -> UserChoice.Small;
                    case 2 -> UserChoice.Medium;
                    case 3 -> UserChoice.Large;
                    default -> throw new IllegalStateException("Unexpected value: " + choice);
                };
            } catch (Exception _) {
                System.out.println("Invalid Choice: Try again.");
            }
        }
    }
    public DrinkChoice getDrinkFlavor() {
        while (true) {
            System.out.print(
                    """
                    \nWhat Drink?
                    \t[1] - Cola
                    \t[2] - Root Beer
                    \t[3] - Orange
                    \t[4] - Lemon Lime
                    \t[5] - Ginger Ale
                    """
            );
            try {
                System.out.print("Your Selection: ");
                int choice = Integer.parseInt(userInput.nextLine().strip());
                return switch (choice) {
                    case 1 -> DrinkChoice.Cola;
                    case 2 -> DrinkChoice.RootBeer;
                    case 3 -> DrinkChoice.Orange;
                    case 4 -> DrinkChoice.LemonLime;
                    case 5 -> DrinkChoice.GingerAle;
                    default -> throw new IllegalStateException("Unexpected value: " + choice);
                };
            } catch (Exception _) {
                System.out.println("Invalid Choice: Try again.");
            }
        }
    }
    public boolean getChips() {
        while(true) {
            System.out.print(
                    "-".repeat(50) + "\n" +
                    " ".repeat(15) + "Build Your Sandwich!" + "\n" +
                    "-".repeat(50) + "\n" +
                    """
                    Would you like Chips:
                    \t[1] - Yes
                    \t[2] - No
                    """);
            try {
                System.out.print("Your Selection: ");
                int choice = Integer.parseInt(userInput.nextLine().strip());
                return choice == 1;
            } catch (Exception _) {
                System.out.println("Invalid Choice: Try again.");
            }
        }
    }
    public ChipChoice getChipBrand() {
        while (true) {
            System.out.print(
                    """
                    \nWhat Chips?
                    \t[1] - Lays
                    \t[2] - Doritos
                    \t[3] - SunChips
                    \t[4] - KettleChips
                    """
            );
            try {
                System.out.print("Your Selection: ");
                int choice = Integer.parseInt(userInput.nextLine().strip());
                return switch (choice) {
                    case 1 -> ChipChoice.Lays;
                    case 2 -> ChipChoice.Doritos;
                    case 3 -> ChipChoice.SunChips;
                    case 4 -> ChipChoice.KettleChips;
                    default -> throw new IllegalStateException("Unexpected value: " + choice);
                };
            } catch (Exception _) {
                System.out.println("Invalid Choice: Try again.");
            }
        }
    }

    public OrderChoice getCheckout(Customer customer) {
        while(true) {
            System.out.print(
                    "-".repeat(50) + "\n" +
                    " ".repeat(21) + "Checkout" + "\n" +
                    "-".repeat(50) + "\n" +
                    customer.toString() + "\n" +
                    """
                    Complete or Cancel Order:
                    \t[1] - Confirm
                    \t[2] - Cancel
                    """);
            try {
                System.out.print("Your Selection: ");
                int choice = Integer.parseInt(userInput.nextLine().strip());
                return switch (choice) {
                    case 1 -> OrderChoice.Receipt;
                    case 2 -> OrderChoice.CancelOrder;
                    default -> throw new IllegalStateException("Unexpected value: " + choice);
                };
            } catch (Exception _) {
                System.out.println("Invalid Choice: Try again.");
            }
        }
    }

    public boolean continueChoice() {
        while (true) {
            System.out.println("Continue?");
            System.out.println("\t[1] - Yes");
            System.out.println("\t[2] - No");
            System.out.print("Your Selection: ");
            try {
                int choice = Integer.parseInt(userInput.nextLine().strip());
                return choice == 1;
            } catch (Exception _) {
                System.out.println("Invalid Choice: Try again.");
            }
        }
    }
}
