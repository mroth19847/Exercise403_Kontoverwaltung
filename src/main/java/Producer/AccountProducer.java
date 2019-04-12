package Producer;

import BL.Account;
import BL.UserModel;

public class AccountProducer implements Runnable{

    private Account account;
    private UserModel bl;

    public AccountProducer(Account account, UserModel bl) {
        this.account = account;
        this.bl = bl;
    }
    
    @Override
    public void run() {
        while(true){
            
        }
    }



}
