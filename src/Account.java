public abstract class Account {
    private double balance;

    public double getBalance() {
        return this.balance;
    }

    public void printBalance() {
        System.out.println("$" + this.balance);
    }

    public void initialBalance() {
        this.balance = 10000;
    }

    public void withdraw(double withdrawAmount) {
        if (withdrawAmount > this.balance) {
            System.out.println("⚠️Withdraw amount larger than current balance");
        } else {
            this.balance -= withdrawAmount;
        }
    }

    public void deposit(double depositAmount) {
        this.balance += depositAmount;
    }

    public String toString(){
        return """
                1 - View Balance
                2 - Withdraw Funds
                3 - Deposit Funds
                4 - Exit
                """;
    }
}
