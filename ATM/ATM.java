import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class ATM {
    private static Map<String, User> users = new HashMap<>();
    private static User loggedInUser;

    public static void main(String[] args) {
        initializeUsers();
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter User ID: ");
        String userId = scanner.nextLine();
        System.out.print("Enter PIN: ");
        String pin = scanner.nextLine();

        if (authenticate(userId, pin)) {
            System.out.println("Welcome!");
            boolean running = true;

            while (running) {
                System.out.println("\n1. View Transaction History\n2. Withdraw\n3. Deposit\n4. Transfer\n5. Quit");
                System.out.print("Choose an option: ");
                int choice = scanner.nextInt();

                switch (choice) {
                    case 1:
                        loggedInUser.getAccount().getTransactionHistory().printHistory();
                        break;
                    case 2:
                        System.out.print("Enter amount to withdraw: ");
                        double withdrawAmount = scanner.nextDouble();
                        if (loggedInUser.getAccount().withdraw(withdrawAmount)) {
                            System.out.println("Withdrawal successful.");
                        } else {
                            System.out.println("Insufficient balance.");
                        }
                        break;
                    case 3:
                        System.out.print("Enter amount to deposit: ");
                        double depositAmount = scanner.nextDouble();
                        loggedInUser.getAccount().deposit(depositAmount);
                        System.out.println("Deposit successful.");
                        break;
                    case 4:
                        System.out.print("Enter target user ID: ");
                        String targetUserId = scanner.next();
                        User targetUser = users.get(targetUserId);
                        if (targetUser != null) {
                            System.out.print("Enter amount to transfer: ");
                            double transferAmount = scanner.nextDouble();
                            loggedInUser.getAccount().transfer(targetUser.getAccount(), transferAmount);
                            System.out.println("Transfer successful.");
                        } else {
                            System.out.println("User not found.");
                        }
                        break;
                    case 5:
                        running = false;
                        System.out.println("Thank you for using the ATM.");
                        break;
                    default:
                        System.out.println("Invalid option. Please try again.");
                }
            }
        } else {
            System.out.println("Invalid user ID or PIN.");
        }
    }

    private static void initializeUsers() {
        users.put("user1", new User("user1", "1234", 500.0));
        users.put("user2", new User("user2", "5678", 300.0));
    }

    private static boolean authenticate(String userId, String pin) {
        loggedInUser = users.get(userId);
        return loggedInUser != null && loggedInUser.getPin().equals(pin);
    }
}

