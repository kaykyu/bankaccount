import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Random;

public class BankAccount {

    private String name;
    private String accountNumber;
    protected float balance;  
    private ArrayList<String> transactions; 
    protected boolean isClosed = false;
    private String createdDate;
    private String closedDate;

    public String getName() {
        return this.name;
    }

    public String getAccountNumber() {
        return this.accountNumber;
    }

    public String getCreatedDate() {
        return createdDate;
    }

    public String getClosedDate() {
        return closedDate;
    }

    private static final String dateFormat= "yyyy-MM-dd HH:mm:ss";
    DateTimeFormatter formatter = DateTimeFormatter.ofPattern(dateFormat);

    protected static String accountNumber() {
        Random r = new Random();
        Integer rand = r.nextInt(1000000000);
        return rand.toString();
    }

    public BankAccount(String name) {
        this.name = name;
        this.balance = 0;
        this.accountNumber = accountNumber();
        LocalDateTime now = LocalDateTime.now();
        this.createdDate = now.format(formatter);
        transactions = new ArrayList<>();
    }

    public BankAccount(String name, float balance) {
        this.name = name;
        this.balance = balance;
        this.accountNumber = accountNumber();
        LocalDateTime now = LocalDateTime.now();
        this.createdDate = now.format(formatter);
        this.transactions = new ArrayList<>();
    }

    public void deposit(float amount) {
        if ((amount < 0) || this.isClosed) {
            System.out.println("IllegalArgumentException");
        } else {
            this.balance += amount;
            LocalDateTime now = LocalDateTime.now();
            String dateTime = now.format(formatter);
            this.transactions.add(String.format("deposited $ %.2f at %s, Balance: %.2f", amount, dateTime, this.balance));
        }
    }

    public void withdraw(float amount) {
        if ((amount > this.balance) || this.isClosed) {
            System.out.println("IllegalArgumentException");           
        } else {
            this.balance -= amount;
            LocalDateTime now = LocalDateTime.now();
            String dateTime = now.format(formatter);
            this.transactions.add(String.format("winthdrew $ %.2f at %s, Balance: %.2f", amount, dateTime, this.balance));
        }
    }

    public void closeAccount() {
        this.isClosed = true;
        LocalDateTime now = LocalDateTime.now();
        this.closedDate = now.format(formatter);
    }

    public static void main(String[] args) {
        
        // test code
        // BankAccount fred = new BankAccount("fred");
        // BankAccount sam = new BankAccount("sam", 100);
        // FixedDepositAccount tom = new FixedDepositAccount("tom", 300);
        // FixedDepositAccount mary = new FixedDepositAccount("mary", 1000);
        // FixedDepositAccount sue = new FixedDepositAccount("sue", 500, 5, 12);
        // fred.deposit(800);
        // fred.deposit(1000);
        // fred.withdraw(500);
        // System.out.println(fred.transactions);
        // System.out.println(fred.transactions);
        // sam.withdraw(50);
        // tom.getBalance();
        // mary.getBalance();
        // sue.getBalance();
        // System.out.println(fred.accountNumber);
        // sam.closeAccount();
        // sam.deposit(100);
        // System.out.println(sam.transactions);
        // System.out.println(fred.accountNumber);
        // mary.deposit(100);
        // sue.withdraw(600);
        // System.out.println(mary.interest);
        // mary.changeInterest(6);
        // System.out.println(mary.interest);
        // mary.changeInterest(5);
        // System.out.println(mary.interest);
        // mary.changeDuration(12);
        // mary.changeDuration(6);
        // System.out.println(mary.duration);
        // System.out.println(sue.getAccountNumber());
        // sue.closeAccount();
        // sue.getBalance();
        // System.out.println(sue.getClosedDate());
    }
}