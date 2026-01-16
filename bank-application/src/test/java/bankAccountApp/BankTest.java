package bankAccountApp;

import org.junit.Test;
import static org.junit.Assert.*;

public class BankTest {

    @Test
    public void getMaximumBalance_shouldReturnHighestBalance() {
        Bank bank = new Bank();

        BankAccount acc1 = new BankAccount();
        acc1.depositMoney(100);

        BankAccount acc2 = new BankAccount();
        acc2.depositMoney(300);

        BankAccount acc3 = new BankAccount();
        acc3.depositMoney(50);

        bank.addAccount(acc1, 0);
        bank.addAccount(acc2, 0);
        bank.addAccount(acc3, 0);

        assertEquals(300.0, bank.getMaximumBalance(), 0.001);
    }
}
