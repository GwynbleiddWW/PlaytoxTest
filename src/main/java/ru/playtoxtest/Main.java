package ru.playtoxtest;

import org.apache.commons.lang3.RandomStringUtils;
import org.apache.commons.lang3.RandomUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Main {
    static final int ACCOUNT_MONEY = 10000;
    private static final Logger logger = LoggerFactory.getLogger(Main.class);

    public static void main(String[] args) {
        logger.info("App running");
        int randomMoneyTransfer1 = RandomUtils.nextInt(10, 99);
        int randomMoneyTransfer2 = RandomUtils.nextInt(70, 120);

        Account a1 = new Account(RandomStringUtils.randomAlphanumeric(11), ACCOUNT_MONEY);
        logger.info("Create Accounts {}", a1.getId());
        Account a2 = new Account(RandomStringUtils.randomNumeric(9), ACCOUNT_MONEY);
        logger.info("Create Accounts {}", a2.getId());
        Account a3 = new Account(RandomStringUtils.randomAlphanumeric(7), ACCOUNT_MONEY);
        logger.info("Create Accounts {}", a3.getId());
        Account a4 = new Account(RandomStringUtils.randomAlphabetic(3), ACCOUNT_MONEY);
        logger.info("Create Accounts {}", a4.getId());

        TransferMoneyThread t1 = new TransferMoneyThread(a1, a2, randomMoneyTransfer1);
        TransferMoneyThread t2 = new TransferMoneyThread(a3, a4, randomMoneyTransfer2);

        for (int i = 0; i < 29; i++) {
            t1.run();
            logger.info("Transfer from a1 to a2: " + a1.getMoney() + " -> " + a2.getMoney());
            t2.run();
            logger.info("Transfer from a3 to a4: " + a3.getMoney() + " -> " + a4.getMoney());
        }
    }
}
