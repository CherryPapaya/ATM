import java.util.Scanner;

public class UserInterface {
    private Scanner scanner;
    private CustomerDB customerDB;
    public UserInterface(Scanner scanner, CustomerDB customerDB) {
        this.scanner = scanner;
        this.customerDB = customerDB;
    }

    public void start() {
        while (true) {
            System.out.println("Welcome");
            System.out.println();
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
                System.out.println("Select the account you want to access");
                System.out.println("1 - Checking Account");
                System.out.println("2 - Saving Account");
                System.out.println("3 - Exit");

                System.out.print("Choice: ");
                int input = Integer.parseInt(scanner.nextLine());
                System.out.println();

                if (input == 3) {
                    break;
                }

                Account account = null;
                switch (input) {
                    case 1:
                        account = customer.getCheckingAccount();
                        System.out.print(account);
                        System.out.print("Choice: ");
                        break;
                    case 2:
                        account = customer.getSavingAccount();
                        System.out.print(account);
                        System.out.print("Choice: ");
                        break;
                }

                input = Integer.parseInt(scanner.nextLine());

                if (input == 4) {
                    break;
                }

                switch (input) {
                    case 1:
                        System.out.println();
                        account.printBalance();
                        break;
                    case 2:
                        System.out.println();
                        account.printBalance();
                        System.out.print("Amount to withdraw: ");
                        double withdrawAmount = Double.parseDouble(scanner.nextLine());
                        account.withdraw(withdrawAmount);

                        System.out.print("New ");
                        account.printBalance();
                        break;
                    case 3:
                        System.out.println();
                        account.printBalance();
                        System.out.print("Amount to deposit: ");
                        double depositAmount = Double.parseDouble(scanner.nextLine());
                        account.deposit(depositAmount);

                        System.out.print("New ");
                        account.printBalance();
                        break;
                }
            }
        }
    }
}
