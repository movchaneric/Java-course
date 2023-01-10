import java.util.Objects;

public class BankAccount {
    public int getAccountID() {
        return accountID;
    }

    public void setAccountID(int accountID) {
        this.accountID = accountID;
    }

    private int accountID;
    private double balance;

    public BankAccount(int id, double balance) {
        this.accountID = id;
        this.balance = balance;
    }


    public synchronized void transaction(double amount) {
        System.out.println(Thread.currentThread().getName() + "is going to transact " + amount +
                            " And bank balance is: " + balance());
        while(amount + this.balance < 0){
              try{
                  wait();
              }catch(InterruptedException e){
                  e.printStackTrace();
              }
        }
        this.balance += amount;
        System.out.println(Thread.currentThread().getName() +
                            " completed the transaction of " +
                                amount + " and balance is: "+
                                balance());
    }

    public synchronized double balance() {
        notifyAll();
        return this.balance;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        BankAccount that = (BankAccount) o;
        return accountID == that.accountID;
    }

    @Override
    public int hashCode() {
        return Objects.hash(accountID);
    }
}
