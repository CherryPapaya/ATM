public abstract class Account {
    private double balance;

    public double getBalance() {
        return this.balance;
    }

    public void initialBalance() {
        this.balance = 10000;
    }

    public void withdraw(double withdrawAmount) {
        if (withdrawAmount > this.balance) {
            System.out.println("⚠️Balance cannot be negative");
        } else {
            this.balance -= withdrawAmount;
        }
    }

    public void deposit(double depositAmount) {
        this.balance += depositAmount;
    }

    public String toString(){
        return "account balance: $" + this.balance;
    }
}
