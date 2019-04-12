package Consumer;

import BL.Account;
import BL.BalanceEmptyException;
import BL.UserModel;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;

public class AccountConsumer implements Runnable{

    private Account account;
    private UserModel bl;

    public AccountConsumer(Account account, UserModel bl) {
        this.account = account;
        this.bl = bl;
    }

    @Override
    public void run() {
        while(true) {
            Random rdm = new Random();
        double money = 10 + (40) * rdm.nextDouble();

        synchronized (account) {
                try {
                    account.withdraw(money);
                    bl.inform(account, Thread.currentThread().getName()+" has withdrawn: -"+String.format("%.2f",money));
                } catch (BalanceEmptyException ex) {
                    try {
                        bl.inform(account, Thread.currentThread().getName()+" waiting for someone to deposit money");
                        account.wait();
                    } catch (InterruptedException ex1) {}
                }
        }

        int time = 1 + rdm.nextInt(1000);
        try {
            Thread.sleep(time);
        } catch (InterruptedException ex) {
        }
        }
    }
    
    
}
