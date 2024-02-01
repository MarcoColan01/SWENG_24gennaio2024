package it.unimi.di.sweng.esame.presenter;

import it.unimi.di.sweng.esame.model.Segnalazione;
import org.jetbrains.annotations.NotNull;

import java.util.*;

public class SecondViewStrategy implements DisplayViewStrategy {
    @Override
    public void sortSegnalazioni(@NotNull List<Segnalazione> segnalazioni) {
        segnalazioni.sort(Comparator.comparing(Segnalazione::data));
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
