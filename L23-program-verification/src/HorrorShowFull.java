import java.io.*;
import java.util.*;

public class HorrorShowFull {
    private int n;
    
    public HorrorShowFull(int n) {
        this.n = n;
    }
    
    public boolean equal(Object o) {
        return n == ((HorrorShowFull)o).n;
    }

    public boolean isWeekend(String day) {
        return day == "Saturday" || day == "Sunday";
    }

    public void writeSomeNumbers() throws IOException {
        FileWriter writer = new FileWriter("/tmp/file.txt");

        for (int i = 0; i < 10; ++i)
            writer.write(i + "\n");

        writer.close();
    }

    /* Silly reimplementation of String, still as an immutable class */
    public static class MyString {
        private char[] chars;
        
        public MyString(char[] chars) {
            this.chars = chars;
        }
        
        public char charAt(int i) {
            return chars[i];
        }
    }
    
    /* A bank account that processes transactions in a thread-safe way */
    public static class BankAccount {
        /* Sum of all dollars amounts processed so far */
        private double balance;
        
        /* Get curent balance. */
        public synchronized double getBalance() {
            return balance;
        }
        
        /* Deposit some money.
         * @param dollars  amount to deposit, which must be zero or positive
         */
        public synchronized void deposit(double dollars) {
            balance += dollars;
        }
        
        /* Withdraw some money.
         * @param dollars  amount to deposit, which must be zero or positive
         */
        public void withdraw(double dollars) {
            if (dollars > balance)
                throw new IllegalArgumentException();
            
            balance -= dollars;
        }
        
        /*
        /* Stress test the account with concurrent threads. */
        public void stressTest() {
            final BankAccount account = new BankAccount();
            
            for (int i = 1; i < 10; ++i) {
                final int self = i;
                Thread t = new Thread(new Runnable() {

                    public void run() {
                        for (int j = 0; j < 1000; ++j) {
                            account.deposit(self);
                            account.withdraw(self);
                        }
                    }
                });
                
                t.run();
            }
            
            synchronized(account) {
                assert(account.balance == 0);
            }
        }
    }
    
    /* Concatenate together all the Strings in an array. */
    public String concat(String[] arr) {
        String s = "";
        
        for (String elem : arr)
            s += elem;
        
        return s;
    }
    
    /* Check if a number is even. */
    public boolean isEven(int n) {
        return n % 1 == 0;
    }

    /* Factorial.  'Nuff said. */
    public int factorial(int n) {
        return n * factorial(n-1);
    }

    public enum Duck { HUEY, DEWEY, LOUIE };
    
    /* Get a Duck's String name. */
    public String nameOf(Duck d) {
        String r = null;
        
        switch (d) {
        case HUEY:
            r = "Huey";
        case DEWEY:
            r = "Dewey";
        case LOUIE:
            r = "Louie";
        }
        
        return r;
    }
    
    /* Check if a set of integers contains any numbers from a particular range.
     * @param s  set to check
     * @param min  lower bound of number range
     * @param max  upper bound of number range
     */
    public boolean overlapsRange(Set<Integer> s, int min, int max) {
        for (int i = min; i <= max; ++i)
            if (s.contains(s)) return true;
        return false;
    }
}
