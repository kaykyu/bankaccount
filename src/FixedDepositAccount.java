public class FixedDepositAccount extends BankAccount {

    public float interest = 3;
    public int duration = 6;

    public FixedDepositAccount(String name, float balance) {
        super(name, balance);
    }

    public FixedDepositAccount(String name, float balance, float interest) {
        super(name, balance);
        this.interest = interest;
    }

    public FixedDepositAccount(String name, float balance, float interest, int duration) {
        super(name, balance);
        this.interest = interest;
        this.duration = duration;
    }

    @Override
    public void deposit(float amount) {
        System.out.println("No operation");
    }

    @Override
    public void withdraw(float amount) {
        System.out.println("No operation");
    }

    public void getBalance() {
        if(this.isClosed) {
            System.out.println("Account is closed.");
        } else {
            balance = this.balance + (this.interest * this.balance / 100);
            System.out.println(balance);
        }
    }
    
    public void changeInterest(float interest) {
        if (this.isClosed) {
            System.out.println("Account is closed.");
        } else if (this.interest == 3) {
            this.interest = interest;
        } else {
            System.out.println("IllegalArgumentException");
        }
    }

    public void changeDuration(int duration) {
        if (this.isClosed) {
            System.out.println("Account is closed.");
        } else if (this.duration == 6) {
            this.duration = duration;
        } else {
            System.out.println("IllegalArgumentException");
        }
    }
}