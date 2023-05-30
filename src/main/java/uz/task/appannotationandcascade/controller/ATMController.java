package uz.task.appannotationandcascade.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import uz.task.appannotationandcascade.repository.ATMService;
import uz.task.appannotationandcascade.service.AtmService;
import uz.task.appannotationandcascade.service.CardBlockedException;
import uz.task.appannotationandcascade.service.InsufficientFundsException;

@RestController
@RequestMapping("/atm")
public class ATMController {
    @Autowired
    private ATMService atmService;

    public ATMController(ATMService atmService) {
        this.atmService = atmService;
    }

    @GetMapping("/balance")
    public ResponseEntity<Integer> checkBalance() {
        int balance = atmService.checkBalance();
        return new ResponseEntity<>(balance, HttpStatus.OK);
    }

    @PostMapping("/withdraw")
    public ResponseEntity<Void> withdraw(@RequestParam int amount) throws InsufficientFundsException {
        atmService.withdraw(amount);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PostMapping("/deposit")
    public ResponseEntity<Void> deposit(@RequestParam int amount) {
        atmService.deposit(amount);
        return new ResponseEntity<>(HttpStatus.OK);
    }


    // Withdraw money from ATM
    @PostMapping("/withdraw")
    public ResponseEntity<String> withdrawMoney(@RequestParam String cardNumber, @RequestParam String pin, @RequestParam double amount) {

        // Check if the PIN is correct
        if (!atmService.isValidPin(cardNumber, pin)) {
            return new ResponseEntity<String>("Invalid PIN code", HttpStatus.UNAUTHORIZED);
        }

        // Check if the ATM has enough money
        if (!atmService.hasEnoughMoney(amount)) {
            return new ResponseEntity<String>("Not enough money in the ATM", HttpStatus.BAD_REQUEST);
        }

        // Check card ownership
        double commission = 0.05; // 5% commission fee
        if (!atmService.isCardOwnedByThisATM(cardNumber)) {
            commission = 0.1; // 10% commission fee for foreign cards
        }

        // Calculate the amount to withdraw
        double totalAmount = amount * (1 + commission);

        // Withdraw money from the account
        boolean success = atmService.withdrawMoney(cardNumber, totalAmount);

        if (success) {
            // Send notification to responsible employee if ATM balance is below threshold
            double minimumBalance = 20.0;
            if (minimumBalance > atmService.getBalance()) {
                atmService.sendNotification("ATM balance is below minimum threshold");
            }
            return new ResponseEntity<String>("Money withdrawn successfully. Commission fee: " + commission, HttpStatus.OK);
        } else {
            return new ResponseEntity<String>("Unable to withdraw money", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    // Handle blocked card exception
    @ExceptionHandler(CardBlockedException.class)
    public ResponseEntity<String> handleCardBlocked() {
        return new ResponseEntity<String>("Your card has been blocked. Please contact your bank", HttpStatus.UNAUTHORIZED);
    }

}
