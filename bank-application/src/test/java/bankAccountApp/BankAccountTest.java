package bankAccountApp;

import org.junit.Test;
import static org.junit.Assert.*;

public class BankAccountTest {

    @Test
    public void depositMoney_happyPath() {
        BankAccount acc = new BankAccount();
        acc.depositMoney(100.0);

        assertEquals(100.0, acc.getBalance(), 0.001);
    }

    @Test
    public void withdrawMoney_edgeCase_exceedsBalance() {
        BankAccount acc = new BankAccount();
        acc.depositMoney(50.0);
        acc.setWithdrawLimit(500.0);

        boolean result = acc.withdrawMoney(100.0);

        assertFalse(result);
        assertEquals(50.0, acc.getBalance(), 0.001);
    }
}
