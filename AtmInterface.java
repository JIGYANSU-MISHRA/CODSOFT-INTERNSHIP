import java.util.Scanner;

class BankAccount {
    private double balance;
    public BankAccount(double balance){
        this.balance = balance;
    }
    public double getBalance(){
        return balance;
    }
    public void setBalance(double balance){
        this.balance = balance;
    }
    public void deposit(double amount){
        balance += amount;
    }
    public boolean withdraw(double amount){
        if (balance >= amount){
            balance -= amount;
            return true;
        }
        return false;
    }
}

public class AtmInterface{
    private BankAccount account;
    public AtmInterface(BankAccount account){
        this.account = account;
    }
    public void start(){
        Scanner scanner = new Scanner(System.in);
        int choice;
        do {
            System.out.println("1. Check Balance");
            System.out.println("2. Deposit");
            System.out.println("3. Withdraw");
            System.out.println("4. Exit");
            System.out.print("Choose an option: ");
            choice = scanner.nextInt();
            switch(choice){
                case 1:
                    checkBalance();
                    break;
                case 2:
                    deposit(scanner);
                    break;
                case 3:
                    withdraw(scanner);
                    break;
                case 4:
                    System.out.println("Exiting...");
                    break;
                default:
                    System.out.println("Invalid choice. Please choose a valid option.");
            }
        } while(choice!= 4);
    }

    private void checkBalance(){
        System.out.println("Your balance is: "+account.getBalance());
    }
    private void deposit(Scanner scanner) {
        System.out.print("Enter amount to deposit: ");
        double amount = scanner.nextDouble();
        if (amount > 0){
            account.deposit(amount);
            System.out.println("Deposit successful. Your new balance is: " + account.getBalance());
        } else{
            System.out.println("Invalid amount. Please enter a positive number.");
        }
    }

    private void withdraw(Scanner scanner){
        System.out.print("Enter amount to withdraw: ");
        double amount = scanner.nextDouble();
        if (amount > 0){
            if (account.withdraw(amount)){
                System.out.println("Withdrawal successful. Your new balance is: " + account.getBalance());
            } else{
                System.out.println("Insufficient balance.");
            }
        } else{
            System.out.println("Invalid amount. Please enter a positive number.");
        }
    }

    public static void main(String[] args){
        BankAccount account = new BankAccount(2000.0);
        AtmInterface atm = new AtmInterface(account);
        atm.start();
    }
}