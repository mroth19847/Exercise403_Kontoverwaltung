package BL;

public class Account {

    private double balance;

    public Account(double balance) {
        this.balance = balance;
    }
    
    public void deposit(double money){
        balance += money;
    }
    
    public void withdraw(double money){
        balance -= money;
    }
    
    public void transferTo(Account receiver, double money){
        withdraw(money);
        receiver.deposit(money);
    }

    public double getBalance() {
        return balance;
    }
    
}
