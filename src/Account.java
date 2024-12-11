public abstract class Account {
    private double balance;

    String getBalance() {
        return "$" + this.balance;
    }

    void initialBalance() {
        this.balance = 10000;
    }

    void withdraw(double withdrawAmount) {
        if (withdrawAmount <= this.balance) {
            System.out.println("⚠️Withdraw amount larger than current balance");
        } else {
            this.balance -= withdrawAmount;
        }
    }

    void deposit(double depositAmount) {
        this.balance += depositAmount;
    }
}
