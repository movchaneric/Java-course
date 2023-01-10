import java.util.ArrayList;

public class TransactionList {
    private ArrayList<Transaction> transactions;

    public TransactionList() {

        this.transactions = new ArrayList<>();

    }

    public void addTranscation(int accountID, double amount){

        Transaction transaction = new Transaction(accountID, amount);

        this.transactions.add(transaction);

    }

    public boolean isNotEmpty(){
        return this.transactions.size() > 0;
    }

    public Transaction currentTransaction(){
        while(this.transactions != null){
            return this.transactions.remove(0);
        }
        return null;
    }

}
