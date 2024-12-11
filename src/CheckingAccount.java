public class CheckingAccount extends Account{

    @Override
    public void printBalance() {
        System.out.print("Checking account balance: ");
        super.printBalance();
    }

    @Override
    public String toString() {
        return "Checking Account:\n" + super.toString();
    }
}
