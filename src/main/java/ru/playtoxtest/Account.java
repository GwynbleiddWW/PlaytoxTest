package ru.playtoxtest;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Account {
    private String id;
    private int money;

    public Account(String id, int money) {
        this.id = id;
        this.money = money;
    }

    public synchronized void deposit(int amount) {
        money += amount;
    }

    public synchronized void withdraw(int amount) {
        if (money < amount) {
            System.out.println("Not enough money");
        }
        money -= amount;
    }
}
