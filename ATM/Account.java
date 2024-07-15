import java.util.ArrayList;

public class Account {
    private double balance;
    private TransactionHistory transactionHistory;

    public Account(double initialBalance) {
        this.balance = initialBalance;
        this.transactionHistory = new TransactionHistory();
    }

    public double getBalance() {
        return balance;
    }

    public void deposit(double amount) {
        balance += amount;
        transactionHistory.addTransaction("Deposit: " + amount);
    }

    public boolean withdraw(double amount) {
        if (amount <= balance) {
            balance -= amount;
            transactionHistory.addTransaction("Withdrawal: " + amount);
            return true;
        }
        return false;
    }

    public void transfer(Account targetAccount, double amount) {
        if (withdraw(amount)) {
            targetAccount.deposit(amount);
            transactionHistory.addTransaction("Transfer: " + amount);
        }
    }

    public TransactionHistory getTransactionHistory() {
        return transactionHistory;
    }
}


