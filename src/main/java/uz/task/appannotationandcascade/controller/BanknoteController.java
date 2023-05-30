package uz.task.appannotationandcascade.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import uz.task.appannotationandcascade.entity.Banknote;
import uz.task.appannotationandcascade.repository.BanknoteService;

import java.util.List;

@RestController
@RequestMapping("/banknotes")
public class BanknoteController {
    @Autowired
    private BanknoteService banknoteService;

    @GetMapping
    public ResponseEntity<List<Banknote>> getBanknotes() {
        List<Banknote> banknotes = banknoteService.getBanknotes();
        return new ResponseEntity<>(banknotes, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Void> addBanknote(@RequestBody Banknote banknote) {
        banknoteService.addBanknote(banknote);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @DeleteMapping
    public ResponseEntity<Void> removeBanknote(@RequestBody Banknote banknote) {
        banknoteService.removeBanknote(banknote);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
