import java.util.Scanner;

// User Account class
class BankAccount {
    private double balance;

    public BankAccount(double initialBalance) {
        this.balance = initialBalance;
    }

    public double getBalance() {
        return balance;
    }

    public void deposit(double amount) {
        balance += amount;
    }

    public boolean withdraw(double amount) {
        if (amount > balance) {
            System.out.println("Insufficient funds. Withdrawal failed.");
            return false;
        } else {
            balance -= amount;
            System.out.println("Withdrawal successful. Remaining balance: Rs " + balance);
            return true;
        }
    }
}

// ATM class
class ATM {
    private BankAccount userAccount;

    public ATM(BankAccount userAccount) {
        this.userAccount = userAccount;
    }

    public void displayOptions() {
        System.out.println("1. Withdraw");
        System.out.println("2. Deposit");
        System.out.println("3. Check Balance");
        System.out.println("4. Exit");
    }

    public void processOption(int option, Scanner scanner) {
        switch (option) {
            case 1:
                System.out.print("Enter withdrawal amount: Rs ");
                double withdrawAmount = scanner.nextDouble();
                if (withdrawAmount > 0) {
                    userAccount.withdraw(withdrawAmount);
                } else {
                    System.out.println("Invalid amount. Withdrawal failed.");
                }
                break;
            case 2:
                System.out.print("Enter deposit amount: Rs ");
                double depositAmount = scanner.nextDouble();
                if (depositAmount > 0) {
                    userAccount.deposit(depositAmount);
                    System.out.println("Deposit successful. New balance: Rs " + userAccount.getBalance());
                } else {
                    System.out.println("Invalid amount. Deposit failed.");
                }
                break;
            case 3:
                System.out.println("Current balance: Rs " + userAccount.getBalance());
                break;
            case 4:
                System.out.println("Exiting. Thank you!");
                System.exit(0);
                break;
            default:
                System.out.println("Invalid option. Please try again.");
        }
    }
}

// Main class
public class AtmClass {
    public static void main(String[] args) {
        BankAccount userAccount = new BankAccount(1000.0);

        ATM atm = new ATM(userAccount);

        Scanner scanner = new Scanner(System.in);

        while (true) {
            atm.displayOptions();
            System.out.print("Choose an option: ");
            int option = scanner.nextInt();

            atm.processOption(option, scanner);
        }
    }
}
