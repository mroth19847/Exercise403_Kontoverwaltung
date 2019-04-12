package BL;

public class Account {

    private double balance;

    public Account(double balance) {
        this.balance = balance;
    }
    
    public void deposit(double money){
        balance += money;
    }
    
    public void withdraw(double money) throws BalanceEmptyException{
        if(balance-money < 0) throw new BalanceEmptyException();
        balance -= money;
    }
    
    public void transferTo(Account receiver, double money) throws BalanceEmptyException{
        withdraw(money);
        receiver.deposit(money);
    }

    public double getBalance() {
        return balance;
    }
    
}
