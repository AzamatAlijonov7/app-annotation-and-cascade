package uz.task.appannotationandcascade.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import uz.task.appannotationandcascade.entity.Card;
import uz.task.appannotationandcascade.repository.CardRepository;

import java.time.Instant;
import java.time.LocalDate;
import java.util.Collections;
import java.util.List;

@Service
public class CardService {
    @Autowired
    private CardRepository cardRepository;

    @Scheduled(cron = "0 0 0 * * *") // run every day at midnight
    public void checkCardValidity() {
        List<Card> cards = cardRepository.findAll();
        LocalDate today = LocalDate.now();
        for (Card card : cards) {
            if (card.getExpirationDate().isBefore(Instant.from(today))) {
                card.setActive(false);
                cardRepository.save(card);
            }
        }
    }

    public void activateCard(Long cardId) {
        Card card = cardRepository.findById(Collections.singletonList(cardId)).orElseThrow(() -> new RuntimeException("Card not found"));
        card.setActive(true);
        cardRepository.save(card);
    }
}
