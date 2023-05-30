package uz.task.appannotationandcascade.service;

import org.springframework.stereotype.Service;
import uz.task.appannotationandcascade.entity.Banknote;
import uz.task.appannotationandcascade.repository.BanknoteService;

import java.util.ArrayList;
import java.util.List;

@Service
public class BanknoteServiceImpl implements BanknoteService {
    private List<Banknote> banknotes = new ArrayList<>();

    @Override
    public List<Banknote> getBanknotes() {
        return banknotes;
    }

    @Override
    public void addBanknote(Banknote banknote) {
        banknotes.add(banknote);
    }

    @Override
    public void removeBanknote(Banknote banknote) {
        banknotes.remove(banknote);
    }
}

