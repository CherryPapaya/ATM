public class SavingAccount extends Account{
    public SavingAccount() {
        super.initialBalance();
    }

    @Override
    public void printBalance() {
        System.out.print("Saving account balance: ");
        super.printBalance();
    }

    @Override
    public String toString() {
        return "Saving Account:\n" + super.toString();
    }
}
