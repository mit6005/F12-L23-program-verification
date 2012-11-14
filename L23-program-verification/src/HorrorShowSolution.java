import java.io.FileWriter;
import java.io.IOException;
import java.util.Set;

public class HorrorShowSolution {
    private int n;
    
    public HorrorShowSolution(int n) {
        this.n = n;
    }
    
    public boolean equals(Object o) {
        if (!(o instanceof HorrorShowSolution)) return false;
        
        return n == ((HorrorShowSolution)o).n;
    }
    
    public int hashCode() {
        return Integer.valueOf(n).hashCode();
    }
    
    /* Does a string name a weekend day?
     * @param day  name of a day of the week
     */
    public boolean isWeekend(String day) {
        return day.equals("Saturday") || day.equals("Sunday");
    }

    /* Write some numbers to a file /tmp/file.txt. */
    public void writeSomeNumbers() throws IOException {
        FileWriter writer = null;
        
        try {
            writer = new FileWriter("/tmp/file.txt");

            for (int i = 0; i < 10; ++i)
                writer.write(i + "\n");

            writer.close();
        } finally {
            if (writer != null)
                writer.close();
        }
    }

    /* Silly reimplementation of String, still as an immutable class */
    public static class MyString {
        private char[] chars;
        
        public MyString(char[] chars) {
            this.chars = chars.clone();
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
        public synchronized void withdraw(double dollars) {
            if (dollars > balance)
                throw new IllegalArgumentException();
            
            balance -= dollars;
        }
        
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
                
                t.start();
            }
            
            synchronized(account) {
                assert(account.balance == 0);
            }
        }
    }
    
    /* Concatenate together all the Strings in an array. */
    public String concat(String[] arr) {
        StringBuffer b = new StringBuffer();
        
        for (String elem: arr)
            b.append(elem);
        
        return b.toString();
    }
    
    /* Check if a number is even. */
    public boolean isEven(int n) {
        return n % 2 == 0;
    }
    
    /* Factorial.  'Nuff said. */
    public int factorial(int n) {
        if (n <= 1)
            return 1;
        else
            return n * factorial(n-1);
    }

    public enum Duck { HUEY, DEWEY, LOUIE };
    
    /* Get a Duck's String name. */
    public String nameOf(Duck d) {
        String r = null;
        
        switch (d) {
        case HUEY:
            r = "Huey";
            break;
        case DEWEY:
            r = "Dewey";
            break;
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
            if (s.contains(i)) return true;
        return false;
    }
    
}
