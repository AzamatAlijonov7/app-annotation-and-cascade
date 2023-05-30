package uz.task.appannotationandcascade.repository;

import jakarta.transaction.Transaction;

import java.util.List;

public interface TransactionService {
    List<Transaction> getTransactions();
    void addTransaction(Transaction transaction);
}
