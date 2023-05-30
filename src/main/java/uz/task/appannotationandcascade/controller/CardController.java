package uz.task.appannotationandcascade.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import uz.task.appannotationandcascade.entity.Card;
import uz.task.appannotationandcascade.repository.CardRepository;

import java.util.Collections;

@RestController
@RequestMapping("/cards")
public class CardController {
    @Autowired
    private CardRepository cardRepository;

    @GetMapping("/{id}")
    public Card getCard(@PathVariable Long id) {
        return cardRepository.findById(Collections.singletonList(id)).orElseThrow(() -> new RuntimeException("Card not found"));
    }

    @PostMapping
    public Card createCard(@RequestBody Card card) {
        return cardRepository.save(card);
    }

    @PutMapping("/{id}")
    public Card updateCard(@PathVariable Long id, @RequestBody Card card) {
        Card existingCard = cardRepository.findById(Collections.singletonList(id)).orElseThrow(() -> new RuntimeException("Card not found"));
        existingCard.equals(card.getBank());
        existingCard.setActive(card.getCvv());
        existingCard.setActive(card.getLastName());
        existingCard.setActive(card.getFirstName());
        existingCard.setExpirationDate(card.getExpirationDate());
        existingCard.setPassword(card.getPassword());
        existingCard.setActive(card.getPlasticType());
        return cardRepository.save(existingCard);
    }

    @DeleteMapping("/{id}")
    public void deleteCard(@PathVariable Long id) {
        cardRepository.deleteById(Collections.singletonList(id));
    }

    @PostMapping("/{id}/activate")
    public void activateCard(@PathVariable Long id) {
        CardController CardService = null;
        CardService.activateCard(id);
    }
}
