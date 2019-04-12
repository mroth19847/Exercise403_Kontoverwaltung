package Observer;

public interface AccountSubject {
    
    public void register(AccountObserver observer);
    
    public void deregister(AccountObserver observer);
    
    public void inform(AccountObserver entry);
}
