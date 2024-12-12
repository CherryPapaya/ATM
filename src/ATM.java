import java.util.Scanner;

public class ATM {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        CustomerDB customerDB = new CustomerDB();

//        customerDB.addCustomer(new Customer(1, 111));
//        customerDB.addCustomer(new Customer(2, 222));
//        customerDB.addCustomer(new Customer(3, 333));

        UserInterface ui = new UserInterface(scanner, customerDB);
        ui.start();
    }
}