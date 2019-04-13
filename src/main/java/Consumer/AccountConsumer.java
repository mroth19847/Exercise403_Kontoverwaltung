package Consumer;

import BL.Account;
import BL.BalanceEmptyException;
import BL.UserModel;
import java.util.Random;

public class AccountConsumer implements Runnable {

    private Account account;
    private UserModel bl;

    public AccountConsumer(Account account, UserModel bl) {
        this.account = account;
        this.bl = bl;
    }

    @Override
    public void run() {
        Random rdm = new Random();

        while (true) {
            double money = 10 + (40) * rdm.nextDouble();

            synchronized (account) {
                try {
                    account.withdraw(money);
                    bl.inform(account, Thread.currentThread().getName() + " has withdrawn: -" + String.format("%.2f", money));
                    break;
                } catch (BalanceEmptyException ex) {
                    try {
                        bl.inform(account, Thread.currentThread().getName() + " can't withdraw, waiting");
                        account.wait();
                    } catch (InterruptedException ex1) {
                    }
                }
            }

        }
        int time = 1 + rdm.nextInt(1000);

        try {
            Thread.sleep(time);
        } catch (InterruptedException ex) {
        }
    }

}
