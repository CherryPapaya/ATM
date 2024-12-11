public class SavingAccount extends Account{
    public SavingAccount() {
        super.initialBalance();
    }

    @Override
    public String toString() {
        return "Saving " + super.toString();
    }
}
