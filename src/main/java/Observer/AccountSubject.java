package Observer;

import BL.Account;

public interface AccountSubject {
    
    public void register(AccountObserver observer);
    
    public void deregister(AccountObserver observer);
    
    public void inform(Account acc, String message);
}
