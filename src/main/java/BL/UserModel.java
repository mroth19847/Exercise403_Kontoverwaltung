package BL;

import Observer.AccountObserver;
import Observer.AccountSubject;
import java.util.ArrayList;
import javax.swing.AbstractListModel;

public class UserModel extends AbstractListModel implements AccountSubject{

    private ArrayList<User> users = new ArrayList<>();
    private ArrayList<AccountObserver> observers = new ArrayList<>();
    
    @Override
    public int getSize() {
        return users.size();
    }

    @Override
    public Object getElementAt(int idx) {
        return users.get(idx);
    }
    
    public void add(User user){
        users.add(user);
        fireIntervalAdded(this, users.size()-1, users.size()-1);
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
