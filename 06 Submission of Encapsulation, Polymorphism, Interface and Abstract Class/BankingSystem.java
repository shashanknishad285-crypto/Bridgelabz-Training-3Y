
interface Loanable {
    void applyForLoan();
    boolean calculateLoanEligibility(double amount);
}

abstract class BankAccount {
    private String accountNumber;
    private String holderName;
    private double balance;

    public BankAccount(String accNum, String holderName, double balance) {
        this.accountNumber = accNum;
        this.holderName = holderName;
        this.balance = balance;
    }

    public String getAccountNumber() { return accountNumber; }
    public String getHolderName() { return holderName; }
    public double getBalance() { return balance; }
    public void deposit(double amount) {
        if(amount > 0) {
            balance += amount;
            System.out.println("Deposited: " + amount);
        }
    }
    public void withdraw(double amount) {
        if(amount > 0 && amount <= balance) {
            balance -= amount;
            System.out.println("Withdrawn: " + amount);
        } else {
            System.out.println("Invalid withdraw amount or insufficient balance.");
        }
    }
    public abstract double calculateInterest();
}

class SavingsAccount extends BankAccount implements Loanable {
    private double interestRate;

    public SavingsAccount(String accNum, String name, double balance, double interestRate) {
        super(accNum, name, balance);
        this.interestRate = interestRate;
    }
    @Override
    public double calculateInterest() {
        return getBalance() * interestRate / 100;
    }
    public void applyForLoan() {
        System.out.println("Applying for loan in Savings Account");
    }
    public boolean calculateLoanEligibility(double amount) {
        return amount <= getBalance() * 2;
    }
}

class CurrentAccount extends BankAccount implements Loanable {
    private double interestRate;

    public CurrentAccount(String accNum, String name, double balance, double interestRate) {
        super(accNum, name, balance);
        this.interestRate = interestRate;
    }
    @Override
    public double calculateInterest() {
        return getBalance() * interestRate / 100;
    }
    public void applyForLoan() {
        System.out.println("Applying for loan in Current Account");
    }
    public boolean calculateLoanEligibility(double amount) {
        return amount <= getBalance();
    }
}

public class BankingSystem {
    public static void main(String[] args) {
        BankAccount[] accounts = {
            new SavingsAccount("S001", "John", 5000, 4),
            new CurrentAccount("C001", "Jane", 3000, 3)
        };
        for(BankAccount acc : accounts) {
            System.out.println("Account Number: " + acc.getAccountNumber() + ", Holder: " + acc.getHolderName());
            System.out.println("Balance: " + acc.getBalance());
            System.out.println("Interest: " + acc.calculateInterest());
            if (acc instanceof Loanable) {
                Loanable loanAcc = (Loanable) acc;
                loanAcc.applyForLoan();
                System.out.println("Loan eligibility for 7000: " + loanAcc.calculateLoanEligibility(7000));
            }
            System.out.println();
        }
    }
}
