import java.util.*;
public class ATM {
    static double balance = 10000;
    static List<String> history = new ArrayList<>();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String userId = "user123";
        String pin = "1234";

        System.out.print("Enter User ID: ");
        String inputId = sc.nextLine();

        System.out.print("Enter PIN: ");
        String inputPin = sc.nextLine();

        if (inputId.equals(userId) && inputPin.equals(pin)) {

            int choice;

            do {
                System.out.println("\n===== ATM MENU =====");
                System.out.println("1. Transaction History");
                System.out.println("2. Withdraw");
                System.out.println("3. Deposit");
                System.out.println("4. Transfer");
                System.out.println("5. Quit");
                System.out.print("Choose option: ");

                choice = sc.nextInt();

                switch (choice) {
                    case 1:
                        showHistory();
                        break;
                    case 2:
                        System.out.print("Enter amount: ");
                        withdraw(sc.nextDouble());
                        break;
                    case 3:
                        System.out.print("Enter amount: ");
                        deposit(sc.nextDouble());
                        break;
                    case 4:
                        System.out.print("Enter amount: ");
                        transfer(sc.nextDouble());
                        break;
                    case 5:
                        System.out.println("Thank you!");
                        break;
                    default:
                        System.out.println("Invalid choice!");
                }
            } while (choice != 5);

        } else {
            System.out.println("Invalid login!");
        }
    }

    static void deposit(double amount) {
        balance += amount;
        history.add("Deposited: " + amount);
        System.out.println("Deposited successfully!");
    }

    static void withdraw(double amount) {
        if (balance >= amount) {
            balance -= amount;
            history.add("Withdrawn: " + amount);
            System.out.println("Withdraw successful!");
        } else {
            System.out.println("Insufficient balance!");
        }
    }

    static void transfer(double amount) {
        if (balance >= amount) {
            balance -= amount;
            history.add("Transferred: " + amount);
            System.out.println("Transfer successful!");
        } else {
            System.out.println("Insufficient balance!");
        }
    }

    static void showHistory() {
        if (history.isEmpty()) {
            System.out.println("No transactions yet.");
        } else {
            for (String t : history) {
                System.out.println(t);
            }
        }
    }
}