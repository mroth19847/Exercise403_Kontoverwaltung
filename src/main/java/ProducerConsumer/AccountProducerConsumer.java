package ProducerConsumer;

import BL.Account;
import BL.BalanceEmptyException;
import BL.UserModel;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;

public class AccountProducerConsumer implements Runnable{

    private Account account;
    private UserModel bl;

    public AccountProducerConsumer(Account account, UserModel bl) {
        this.account = account;
        this.bl = bl;
    }
    
    @Override
    public void run() {
        Random rdm = new Random();
        for (int i = 0; i < 10; i++) {
            int x = rdm.nextInt(2);
            double money = 10 + (40) * rdm.nextDouble();
            
            if(x == 1) try {
                account.withdraw(money);
            } catch (BalanceEmptyException ex) {
                Logger.getLogger(AccountProducerConsumer.class.getName()).log(Level.SEVERE, null, ex);
            }
            else account.deposit(money);
            
            int time = 1 + rdm.nextInt(1000);
            try {
                Thread.sleep(time);
            } catch (InterruptedException ex) {}
        }
    }
}
