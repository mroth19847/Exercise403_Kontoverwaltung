package Producer;

import BL.Account;
import BL.UserModel;
import java.util.Random;

public class AccountProducer implements Runnable {

    private Account account;
    private UserModel bl;

    public AccountProducer(Account account, UserModel bl) {
        this.account = account;
        this.bl = bl;
    }

    @Override
    public void run() {
        Random rdm = new Random();
        double money = 10 + (40) * rdm.nextDouble();

        synchronized (account) {
            account.deposit(money);
            bl.inform(account, Thread.currentThread().getName()+" has deposited: +"+String.format("%.2f",money));
            account.notifyAll();
        }

        int time = 1 + rdm.nextInt(1000);
        try {
            Thread.sleep(time);
        } catch (InterruptedException ex) {
        }

    }
}
