package uz.task.appannotationandcascade.service;

import org.springframework.stereotype.Service;
import uz.task.appannotationandcascade.repository.ATMService;

@Service
public class ATMServiceImpl implements ATMService {
    private int balance = 0;

    @Override
    public int checkBalance() {
        return balance;
    }

    @Override
    public void withdraw(int amount) throws InsufficientFundsException {
        if (amount > balance) {
            throw new InsufficientFundsException("Insufficient funds");
        }

        balance -= amount;
    }

    @Override
    public void deposit(int amount) {
        balance += amount;
    }

    @Override
    public boolean isValidPin(String cardNumber, String pin) {
        return false;
    }

    @Override
    public boolean hasEnoughMoney(double amount) {
        return false;
    }

    @Override
    public boolean isCardOwnedByThisATM(String cardNumber) {
        return false;
    }

    @Override
    public boolean withdrawMoney(String cardNumber, double totalAmount) {
        return false;
    }

    @Override
    public boolean getBalance() {
        return false;
    }

    @Override
    public void sendNotification(String s) {

    }
}
