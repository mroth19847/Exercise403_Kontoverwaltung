package BL;

import Consumer.AccountConsumer;
import Observer.AccountObserver;
import Observer.AccountSubject;
import Producer.AccountProducer;
import java.util.ArrayList;
import java.util.Random;
import javax.swing.AbstractListModel;

public class UserModel extends AbstractListModel implements AccountSubject {

    private ArrayList<User> users = new ArrayList<>();
    private ArrayList<AccountObserver> observers = new ArrayList<>();
    private Account account;

    public void setAccount(Account account) {
        this.account = account;
    }

    public void test() throws Exception {
        Random rdm = new Random();
        for (User user : users) {
            for (int i = 0; i < 10; i++) {
                int x = rdm.nextInt(2);
                try {
                    if (x == 0) {
                        new Thread(new AccountProducer(account, this), user.getName()).start();
                    } else {
                        new Thread(new AccountConsumer(account, this), user.getName()).start();
                    }
                } catch (NullPointerException npe) {
                    throw new Exception("Account hasn't been created yet!");
                }
            }
        }
    }

    @Override
    public int getSize() {
        return users.size();
    }

    @Override
    public Object getElementAt(int idx) {
        return users.get(idx);
    }

    public void add(User user) {
        users.add(user);
        fireIntervalAdded(this, users.size() - 1, users.size() - 1);
    }

    @Override
    public void register(AccountObserver observer) {
        observers.add(observer);
    }

    @Override
    public void deregister(AccountObserver observer) {
        observers.remove(observer);
    }

    @Override
    public void inform(Account acc, String message) {
        for (AccountObserver observer : observers) {
            observer.update(acc, message);
        }
    }

}
