import java.util.ArrayList;
import java.util.HashMap;

public class Main {

    public static void main(String[] args) {
        BankAccount[] bankAccount = new BankAccount[5];
        final int TOTAL_TRANSACTION_NUM = 50;
        final int NUM_OF_ACCOUNTS = 5;
        int randomAmount, j = 0, k = 0;;

        //init 5 bank accounts with id's : 0...4 and balance of 0
        for (int i = 0; i < bankAccount.length; i++) {

            bankAccount[i] = new BankAccount(i, 0);

        }

        HashMap<Integer,BankAccount> bankAccounts = new HashMap<>();

        //bankAccounts.put(bk1.getAccountID(),bk1);
        
        for (int i = 0; i < bankAccount.length; i++) {

            bankAccounts.put(bankAccount[i].getAccountID(), bankAccount[i]);
        }

        TransactionList transactions =new TransactionList();

        //Create list with 50 different transactions amount
        while(j < TOTAL_TRANSACTION_NUM){

            //Each bank account with 10 transactions
            if(k < NUM_OF_ACCOUNTS){

                //Generate random numbers between [1000, -1000]
                randomAmount = -1000 + (int) (Math.random() * ((1000 - (-1000)) + 1));;

                transactions.addTranscation(bankAccount[k].getAccountID(), randomAmount);

                k += 1;

                j += 1;
            } else{

                k = 0;

            }
        }


        //Create list of 10 bank accounts
        BankTeller[] bankTellerList = new BankTeller[10];

        for (int i = 0; i < bankTellerList.length; i++) {

            bankTellerList[i] = new BankTeller(transactions,bankAccounts);

        }

        Thread[] bankTellerThreads = new Thread[10];

        //Init all 10 threads
        for (int i = 0; i < bankTellerThreads.length; i++) {

            bankTellerThreads[i] = new Thread((bankTellerList[i]));

        }

        //Start all 10 threads
        for (int i = 0; i < bankTellerThreads.length; i++) {

            bankTellerThreads[i].start();

        }
    }

}