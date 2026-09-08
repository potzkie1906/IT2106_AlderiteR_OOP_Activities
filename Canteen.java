import java.util.Scanner;

public class Canteen {

    public static void main(String[] args) {
        // Menu items and prices
        try (Scanner scanner = new Scanner(System.in)) {
            // Menu items and prices
            String[] menuItems = {"Burger", "Pizza", "Pasta", "Sandwich", "Milk Tea"};
            double[] prices = {80.00, 120.00, 100.00, 70.00, 90.00};
            
            char orderAgain = 'Y';
            
            while (orderAgain == 'Y' || orderAgain == 'y') {
                // Print Menu
                System.out.println("=====  M E N U  =====");
                for (int i = 0; i < menuItems.length; i++) {
                    System.out.printf("%d. %-14s - $%.2f%n", (i + 1), menuItems[i], prices[i]); 
                }
                System.out.println();
                
                // Inputs
                System.out.print("Enter item number: ");
                int itemNumber = scanner.nextInt();
                
                System.out.print("Enter quantity: ");
                int quantity = scanner.nextInt();
                
                // Validation
                if (itemNumber < 1 || itemNumber > menuItems.length || quantity <= 0) {
                    System.out.println("\nInvalid order! Please enter a valid item and quantity.");
                } else {
                    System.out.print("Are you a student? (Y/N): ");
                    char isStudent = scanner.next().charAt(0);
                    
                    // Calculations
                    double subtotal = prices[itemNumber - 1] * quantity;
                    double discount = 0.0;
                    
                    if (isStudent == 'Y' || isStudent == 'y') {
                        discount = subtotal * 0.10;
                    }
                    
                    double orderTotal = subtotal - discount;
                    
                    // Output Results
                    System.out.println();
                    System.out.printf("Subtotal: $%.2f%n", subtotal);
                    System.out.printf("Discount: $%.2f%n", discount);
                    System.out.printf("Order total: $%.2f%n", orderTotal);
                }
                
                // Loop Prompt
                System.out.println();
                System.out.print("Do you want to order again? (Y/N): ");
                orderAgain = scanner.next().charAt(0);
                System.out.println();
            }
        }
    }
}