package it.unimi.di.sweng.esame.presenter;

import it.unimi.di.sweng.esame.model.Segnalazione;
import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.List;

public class ThirdViewStrategy implements DisplayViewStrategy {
    @Override
    public void sortSegnalazioni(@NotNull List<Segnalazione> segnalazioni) {
        segnalazioni.sort((o1, o2) -> Integer.compare(o2.criticity().ordinal(), o1.criticity().ordinal()));
    }

    @Override
    public List<String> printSegnalazioni(List<Segnalazione> segnalazioni) {
        sortSegnalazioni(segnalazioni);
        List<String> s = new ArrayList<>();
        for (Segnalazione segnalazione : segnalazioni) {
            s.add(segnalazione.nomeCitta() + " " + segnalazione.criticity() + " " + segnalazione.data());
        }
        return s;
    }
}
