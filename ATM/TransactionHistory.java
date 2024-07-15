import java.util.ArrayList;

public class TransactionHistory {
    private ArrayList<Transaction> transactions;

    public TransactionHistory() {
        transactions = new ArrayList<>();
    }

    public void addTransaction(String details) {
        transactions.add(new Transaction(details));
    }

    public void printHistory() {
        for (Transaction transaction : transactions) {
            System.out.println(transaction.getDetails());
        }
    }
}


