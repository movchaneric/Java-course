import java.util.HashMap;
import java.util.HashSet;

public class BankTeller implements Runnable {
    private TransactionList transactions;
    private HashMap<Integer,BankAccount> bankAccounts;

    private final static int SLEEP_TIME = 100;

    public BankTeller(TransactionList transactions, HashMap<Integer,BankAccount> bankAccounts) {
        this.transactions = transactions;
        this.bankAccounts = bankAccounts;
    }

    @Override
    public void run() {
        do{
            Transaction currentTransaction = this.transactions.currentTransaction();

            BankAccount currentBankAccount = this.bankAccounts.get(currentTransaction.getAccountId());

            currentBankAccount.transaction(currentTransaction.getAmount());
            try {
                Thread.sleep(SLEEP_TIME);

            }
            catch (InterruptedException e) {

                throw new RuntimeException(e);

            }
        }while(transactions.isNotEmpty());

    }
}
