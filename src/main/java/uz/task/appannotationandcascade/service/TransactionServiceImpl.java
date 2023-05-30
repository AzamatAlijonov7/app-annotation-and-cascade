package uz.task.appannotationandcascade.service;


import jakarta.transaction.Transaction;
import org.springframework.stereotype.Service;
import uz.task.appannotationandcascade.repository.TransactionService;

import java.util.ArrayList;
import java.util.List;

@Service
public class TransactionServiceImpl implements TransactionService {
    private List<Transaction> transactions = new ArrayList<>();

    @Override
    public List<Transaction> getTransactions() {
        return transactions;
    }

    @Override
    public void addTransaction(Transaction transaction) {
        transactions.add(transaction);
    }
}
