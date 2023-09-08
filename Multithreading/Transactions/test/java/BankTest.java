import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class BankTest {
    private Bank bank;

    @BeforeEach
    public void setBank(){
        bank = new Bank();
        bank.getAccounts().put("111111", new Account(100000));
        bank.getAccounts().put("222222", new Account(50000));
    }


    @RepeatedTest(5)
    @DisplayName("Test Fraud Detection in Multi-threaded Environment")
    public void testFraudDetectionMultithreaded() throws InterruptedException{
        ExecutorService executor = Executors.newFixedThreadPool(5);

        for (int i = 0; i < 5; i++) {
            executor.submit(() ->{
                Account fromAccount = bank.getAccounts().get("111111");
                Account toAccount = bank.getAccounts().get("222222");
                fromAccount.setBlocked(false);
                toAccount.setBlocked(false);

                bank.transfer("111111", "222222", 60000);
            });
        }
        executor.shutdown();
        executor.awaitTermination(10, TimeUnit.SECONDS);

        assertTrue(bank.getAccounts().get("111111").isBlocked());
        assertTrue(bank.getAccounts().get("222222").isBlocked());
    }

    @RepeatedTest(5)
    @DisplayName("Test getBalance in Multi-threaded Environment")
    public void testGetBalanceMultithreaded() throws InterruptedException {
        ExecutorService executor = Executors.newFixedThreadPool(5);

        for (int i = 0; i < 5; i++) {
            executor.submit(() -> {
                long balance = bank.getBalance("111111");
                long balance2 = bank.getBalance("222222");
                assertEquals(100000, balance);
                assertEquals(50000, balance2);
            });
        }

        executor.shutdown();
        executor.awaitTermination(10, TimeUnit.SECONDS);
    }
    @RepeatedTest(5)
    @DisplayName("Test getSumAllAccounts in Multi-threaded Environment")
    public void testGetSumAllAccountsMultithreaded() throws InterruptedException {
        ExecutorService executor = Executors.newFixedThreadPool(5);

        for (int i = 0; i < 5; i++) {
            executor.submit(() -> {
                long totalBalance = bank.getSumAllAccounts();
                assertEquals(150000, totalBalance);
            });
        }

        executor.shutdown();
        executor.awaitTermination(10, TimeUnit.SECONDS);
    }



}
