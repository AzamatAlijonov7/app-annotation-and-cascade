package uz.task.appannotationandcascade.repository;

import uz.task.appannotationandcascade.service.InsufficientFundsException;

public interface ATMService {
    int checkBalance();
    void withdraw(int amount) throws InsufficientFundsException;
    void deposit(int amount);

    boolean isValidPin(String cardNumber, String pin);

    boolean hasEnoughMoney(double amount);

    boolean isCardOwnedByThisATM(String cardNumber);

    boolean withdrawMoney(String cardNumber, double totalAmount);

    boolean getBalance();

    boolean getBalance();

    void sendNotification(String s);
}
