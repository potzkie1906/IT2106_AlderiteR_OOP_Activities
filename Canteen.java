import java.util.Scanner;

public class CanteenOrderingSystem {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Menu Data
        String[] menuItems = {"Burger", "Pizza", "Pasta", "Sandwich", "Milk Tea"};
        double[] prices = {80.00, 120.00, 100.00, 70.00, 90.00};

        // Cumulative Trackers
        int totalQuantityPurchased = 0;
        double totalAmountBeforeDeductions = 0.0;
        boolean isStudent = false;

        // Ask student status once at the beginning
        System.out.print("Are you a student? (Y/N): ");
        char studentInput = scanner.next().charAt(0);
        if (studentInput == 'Y' || studentInput == 'y') {
            isStudent = true;
        }

        char orderAgain = 'Y';

        while (orderAgain == 'Y' || orderAgain == 'y') {
            // 1. Display Menu
            System.out.println("\n=====  M E N U  =====");
            for (int i = 0; i < menuItems.length; i++) {
                System.out.printf("%d. %-14s - $%.2f%n", (i + 1), menuItems[i], prices[i]);
            }
            System.out.println();

            // 2. Read Item Number and Quantity
            System.out.print("Enter item number: ");
            int itemNumber = scanner.nextInt();

            System.out.print("Enter quantity: ");
            int quantity = scanner.nextInt();

            // 3. Validation: Item must be 1-5, quantity must be 1-10
            if (itemNumber < 1 || itemNumber > menuItems.length || quantity < 1 || quantity > 10) {
                System.out.println("\nInvalid order! Please enter a valid item (1-5) and quantity (1-10).");
            } else {
                // Add to running totals
                totalQuantityPurchased += quantity;
                totalAmountBeforeDeductions += (prices[itemNumber - 1] * quantity);
            }

            // 5. Ask to order again
            System.out.print("\nDo you want to order again? (Y/N): ");
            orderAgain = scanner.next().charAt(0);
        }

        // 4. Calculate Final Deductions based on overall total
        double deductionPercentage = 0.0;

        if (isStudent && totalAmountBeforeDeductions >= 500.0) {
            deductionPercentage = 0.15; // 15% deduction
        } else if (isStudent) {
            deductionPercentage = 0.10; // 10% deduction
        } else if (totalAmountBeforeDeductions >= 500.0) {
            deductionPercentage = 0.05; // 5% deduction
        }

        double totalDeduction = totalAmountBeforeDeductions * deductionPercentage;
        double finalAmountToPay = totalAmountBeforeDeductions - totalDeduction;

        // 8. Final Transaction Summary
        System.out.println("\n=================================");
        System.out.println("       FINAL TRANSACTION        ");
        System.out.println("=================================");
        System.out.println("Total quantity of items: " + totalQuantityPurchased);
        System.out.printf("Total before deductions: $%.2f%n", totalAmountBeforeDeductions);
        System.out.printf("Total deduction:         $%.2f%n", totalDeduction);
        System.out.printf("Final amount to pay:     $%.2f%n", finalAmountToPay);
        System.out.println("=================================");

        scanner.close();
    }
}