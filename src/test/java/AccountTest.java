import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import ru.playtoxtest.Account;
import ru.playtoxtest.TransferMoneyThread;

public class AccountTest {

    @Test
    void negativeTestTransferMoney() throws Exception {
        Account account1 = new Account("tr", 10);
        Account account2 = new Account("ou", 100000);
        TransferMoneyThread transferMoneyThread = new TransferMoneyThread(account1, account2, 10000);
        transferMoneyThread.run();
        Assertions.assertTrue(account1.getMoney() <= 0);
    }

}
