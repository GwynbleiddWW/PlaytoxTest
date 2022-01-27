package ru.playtoxtest;

public class TransferMoneyThread implements Runnable {

    private final Account to;
    private final Account from;
    private final int amount;

    public TransferMoneyThread(Account from, Account to, int amount) {
        this.from = from;
        this.to = to;
        this.amount = amount;
    }

    @Override
    public void run() {
        try {
            Thread.sleep(1500);
            if (from.getMoney() < 0) {
                throw new IllegalArgumentException();
            } else {
                from.withdraw(amount);
                to.deposit(amount);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
