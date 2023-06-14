import java.util.ArrayList;
import java.util.Scanner;

class Transaction {
    private String type;
    private double amount;

    public Transaction(String type, double amount) {
        this.type = type;
        this.amount = amount;
    }

    public String getType() {
        return type;
    }

    public double getAmount() {
        return amount;
    }
}

class Account {
    private double balance;
    private ArrayList<Transaction> transactionHistory;

    public Account() {
        balance = 0;
        transactionHistory = new ArrayList<>();
    }

    public double getBalance() {
        return balance;
    }

    public void deposit(double amount) {
        balance += amount;
        Transaction transaction = new Transaction("Deposit", amount);
        transactionHistory.add(transaction);
        System.out.println("Successfully deposited $" + amount);
    }

    public void withdraw(double amount) {
        if (balance >= amount) {
            balance -= amount;
            Transaction transaction = new Transaction("Withdrawal", amount);
            transactionHistory.add(transaction);
            System.out.println("Successfully withdrew $" + amount);
        } else {
            System.out.println("Insufficient funds!");
        }
    }

    public void transfer(double amount) {
        if (balance >= amount) {
            balance -= amount;
            Transaction transaction = new Transaction("Transfer", amount);
            transactionHistory.add(transaction);
            System.out.println("Successfully transferred $" + amount);
        } else {
            System.out.println("Insufficient funds!");
        }
    }

    public void printTransactionHistory() {
        System.out.println("Transaction History:");
        for (Transaction transaction : transactionHistory) {
            System.out.println(transaction.getType() + ": $" + transaction.getAmount());
        }
    }
}

public class ATMInterface {
    public static void main(String[] args) {
        Account account = new Account();
        Scanner scanner = new Scanner(System.in);

        boolean quit = false;
        while (!quit) {
            System.out.println("ATM Interface");
            System.out.println("1. Transaction History");
            System.out.println("2. Withdraw");
            System.out.println("3. Deposit");
            System.out.println("4. Transfer");
            System.out.println("5. Quit");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    account.printTransactionHistory();
                    break;
                case 2:
                    System.out.print("Enter amount to withdraw: ");
                    double withdrawAmount = scanner.nextDouble();
                    account.withdraw(withdrawAmount);
                    break;
                case 3:
                    System.out.print("Enter amount to deposit: ");
                    double depositAmount = scanner.nextDouble();
                    account.deposit(depositAmount);
                    break;
                case 4:
                    System.out.print("Enter amount to transfer: ");
                    double transferAmount = scanner.nextDouble();
                    account.transfer(transferAmount);
                    break;
                case 5:
                    quit = true;
                    break;
                default:
                    System.out.println("Invalid choice!");
            }

            System.out.println();
        }
        scanner.close();
        System.out.println("Thank you for using the ATM interface!");
    }
}
