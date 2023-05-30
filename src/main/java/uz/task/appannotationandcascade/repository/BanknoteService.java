package uz.task.appannotationandcascade.repository;

import uz.task.appannotationandcascade.entity.Banknote;

import java.util.List;

public interface BanknoteService {
    List<Banknote> getBanknotes();
    void addBanknote(Banknote banknote);
    void removeBanknote(Banknote banknote);
}
