package BL;

import java.util.logging.Level;
import java.util.logging.Logger;
import static org.junit.Assert.assertEquals;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

public class AccountTest {

    public AccountTest() {
    }

    @Test
    public void testAccountFunctions() {
        Account acc1 = new Account(50);
        Account acc2 = new Account(50);
        acc1.deposit(20);
        assertEquals(70, acc1.getBalance(), 0.01);
        System.out.println("deposit test was successful");
        try {
            acc2.withdraw(20);
        } catch (BalanceEmptyException ex) {
            Logger.getLogger(AccountTest.class.getName()).log(Level.SEVERE, null, ex);
        }
        assertEquals(30, acc2.getBalance(), 0.01);
        System.out.println("withddraw test was successful");
        try {
            acc1.transferTo(acc2, 20);
        } catch (BalanceEmptyException ex) {
            Logger.getLogger(AccountTest.class.getName()).log(Level.SEVERE, null, ex);
        }
        assertEquals(50, acc1.getBalance(), 0.01);
        assertEquals(50, acc2.getBalance(), 0.01);
        System.out.println("transfer test was successful");
    }

}
