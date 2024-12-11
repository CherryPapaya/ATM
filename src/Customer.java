//import java.util.Random;

public class Customer {
//    private Random random;
    private int customerID;
    private int pinCode;
    private Account checkingAccount;
    private Account savingAccount;

    public Customer(int customerID, int pinCode) {
//        this.random = new Random();

        this.customerID = customerID;
        this.pinCode = pinCode;
        this.checkingAccount = new CheckingAccount();
        this.savingAccount = new SavingAccount();
    }

    public Account getCheckingAccount() {
        return this.checkingAccount;
    }

    public Account getSavingAccount() {
        return this.savingAccount;
    }

    public int getCustomerID() {
        return customerID;
    }

    public void setCustomerID(int customerID) {
        this.customerID = customerID;
    }

    public int getPinCode() {
        return pinCode;
    }

    public void setPinCode(int pinCode) {
        this.pinCode = pinCode;
    }

}
