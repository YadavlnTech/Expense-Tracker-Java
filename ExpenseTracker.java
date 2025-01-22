import java.util.ArrayList;
import java.util.Scanner;

public class ExpenseTracker {

    // Expense Model class
    static class Expense {
        private String category;
        private double amount;
        private String description;

        // Constructor
        public Expense(String category, double amount, String description) {
            this.category = category;
            this.amount = amount;
            this.description = description;
        }

        // Getters and Setters
        public String getCategory() {
            return category;
        }

        public void setCategory(String category) {
            this.category = category;
        }

        public double getAmount() {
            return amount;
        }

        public void setAmount(double amount) {
            this.amount = amount;
        }

        public String getDescription() {
            return description;
        }

        public void setDescription(String description) {
            this.description = description;
        }

        // To String method for displaying expense details
        @Override
        public String toString() {
            return "Category: " + category + ", Amount: $" + amount + ", Description: " + description;
        }
    }

    // ExpenseTracker functionality
    private ArrayList<Expense> expenses;

    public ExpenseTracker() {
        expenses = new ArrayList<>();
    }

    // Method to add an expense
    public void addExpense(String category, double amount, String description) {
        Expense expense = new Expense(category, amount, description);
        expenses.add(expense);
        System.out.println("Expense added successfully!");
    }

    // Method to view all expenses
    public void viewExpenses() {
        if (expenses.isEmpty()) {
            System.out.println("No expenses recorded.");
        } else {
            System.out.println("\nExpenses List:");
            for (Expense expense : expenses) {
                System.out.println(expense);
            }
        }
    }

    // Method to calculate total expenses
    public void calculateTotal() {
        double total = 0;
        for (Expense expense : expenses) {
            total += expense.getAmount();
        }
        System.out.println("Total Expenses: $" + total);
    }

    public static void main(String[] args) {
        ExpenseTracker tracker = new ExpenseTracker();
        Scanner scanner = new Scanner(System.in);
        int choice;

        do {
            System.out.println("\n--- Expense Tracker ---");
            System.out.println("1. Add Expense");
            System.out.println("2. View All Expenses");
            System.out.println("3. Calculate Total Expenses");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();
            scanner.nextLine();  // Consume newline

            switch (choice) {
                case 1:
                    // Add an expense
                    System.out.print("Enter category: ");
                    String category = scanner.nextLine();
                    System.out.print("Enter amount: ");
                    double amount = scanner.nextDouble();
                    scanner.nextLine();  // Consume newline
                    System.out.print("Enter description: ");
                    String description = scanner.nextLine();
                    tracker.addExpense(category, amount, description);
                    break;
                case 2:
                    // View all expenses
                    tracker.viewExpenses();
                    break;
                case 3:
                    // Calculate total expenses
                    tracker.calculateTotal();
                    break;
                case 4:
                    // Exit the program
                    System.out.println("Exiting Expense Tracker. Goodbye!");
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        } while (choice != 4);

        scanner.close();
    }
}
