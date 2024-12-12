import java.util.Scanner;

public class UserInterface {
    private Scanner scanner;
    private CustomerDB customerDB;
    public UserInterface(Scanner scanner, CustomerDB customerDB) {
        this.scanner = scanner;
        this.customerDB = customerDB;
    }

    public void start() {
        System.out.println("WELCOME");
        while (true) {
            int input;
            System.out.println();
            System.out.println("What would you like to do?");
            System.out.println("""
                    1 - Sign in
                    2 - Create Account
                    3 - Exit
                    """);
            System.out.print("Choice: ");
            input = Integer.parseInt(scanner.nextLine());
            System.out.println();

            if (input == 3) {
                break;
            }

            if (input == 2) {
                System.out.println("Creating new account");
                while (true) {
                    System.out.print("Enter customer ID: ");
                    int customerID = Integer.parseInt(scanner.nextLine());

                    if (this.customerDB.customerExists(customerID)) {
                        System.out.println("Account already exists!");
                        continue;
                    }

                    System.out.print("Enter PIN: ");
                    int pinCode = Integer.parseInt(scanner.nextLine());

                    if (this.customerDB.pinCodeTaken(pinCode)) {
                        System.out.println("PIN already taken!");
                        continue;
                    }

                    this.customerDB.addCustomer(new Customer(customerID, pinCode));
                    break;
                }
                continue;
            }

            if (input == 1) {
                System.out.print("Enter customer ID: ");
                int customerID = Integer.parseInt(scanner.nextLine());

                if (!this.customerDB.customerExists(customerID)) {
                    System.out.println("Account does not exist.");
                    continue;
                }

                Customer customer = this.customerDB.getCustomer(customerID);

                System.out.print("Enter PIN: ");
                int pinCode = Integer.parseInt(scanner.nextLine());

                if (pinCode != customer.getPinCode()) {
                    System.out.println("Wrong PIN.");
                    continue;
                }

                while (true) {
                    System.out.println();
                    showAccountMenu();
                    System.out.print("Choice: ");
                    input = Integer.parseInt(scanner.nextLine());
                    System.out.println();

                    if (input == 3) {
                        break;
                    }

                    Account account = null;
                    switch (input) {
                        case 1:
                            account = customer.getCheckingAccount();
                            System.out.println("Checking account:");
                            break;
                        case 2:
                            account = customer.getSavingAccount();
                            System.out.println("Saving account:");
                            break;
                    }

                    showOptionMenu();
                    System.out.print("Choice: ");

                    input = Integer.parseInt(scanner.nextLine());

                    if (input == 4) {
                        continue;
                    }

                    switch (input) {
                        case 1:
                            System.out.println();
                            System.out.println(account);
                            break;
                        case 2:
                            System.out.println();
                            System.out.println(account);
                            System.out.print("Amount to withdraw: ");
                            double withdrawAmount = Double.parseDouble(scanner.nextLine());
                            account.withdraw(withdrawAmount);

                            System.out.println("New " + account);
                            break;
                        case 3:
                            System.out.println();
                            System.out.println(account);
                            System.out.print("Amount to deposit: ");
                            double depositAmount = Double.parseDouble(scanner.nextLine());
                            account.deposit(depositAmount);

                            System.out.println("New " + account);
                            break;
                    }
                }
            }
        }
    }

    public void showOptionMenu() {
        System.out.println("""
                1 - View Balance
                2 - Withdraw Funds
                3 - Deposit Funds
                4 - Exit
                """);
    }

    public void showAccountMenu() {
        System.out.println(""" 
                Select the account you want to access
                1 - Checking Account
                2 - Saving Account
                3 - Exit
                """);
    }
}
