
class BankAccount {
    protected String accountNumber;
    protected double balance;
    public BankAccount(String accountNumber, double balance){
        this.accountNumber = accountNumber;
        this.balance = balance;
    }
    public void displayAccountType(){
        System.out.println("Bank Account");
    }
}
class SavingsAccount extends BankAccount {
    private double interestRate;
    public SavingsAccount(String accountNumber, double balance, double interestRate){
        super(accountNumber, balance);
        this.interestRate = interestRate;
    }
    @Override
    public void displayAccountType(){
        System.out.println("Savings Account");
        System.out.println("Interest Rate: " + interestRate);
    }
}
class CheckingAccount extends BankAccount {
    private double withdrawalLimit;
    public CheckingAccount(String accountNumber, double balance, double withdrawalLimit){
        super(accountNumber, balance);
        this.withdrawalLimit = withdrawalLimit;
    }
    @Override
    public void displayAccountType(){
        System.out.println("Checking Account");
        System.out.println("Withdrawal Limit: " + withdrawalLimit);
    }
}
class FixedDepositAccount extends BankAccount {
    private double maturityAmount;
    public FixedDepositAccount(String accountNumber, double balance, double maturityAmount){
        super(accountNumber, balance);
        this.maturityAmount = maturityAmount;
    }
    @Override
    public void displayAccountType(){
        System.out.println("Fixed Deposit Account");
        System.out.println("Maturity Amount: " + maturityAmount);
    }
}
public class BankAccountHierarchy {
    public static void main(String[] args){
        BankAccount[] accounts = {
            new SavingsAccount("SA123", 10000, 4.5),
            new CheckingAccount("CA123", 5000, 1000),
            new FixedDepositAccount("FD123", 20000, 22000)
        };
        for (BankAccount acc : accounts) {
            acc.displayAccountType();
            System.out.println();
        }
    }
}
