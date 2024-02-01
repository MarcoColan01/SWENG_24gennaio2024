package it.unimi.di.sweng.esame.presenter;

import org.jetbrains.annotations.NotNull;

import java.util.*;

public class FirstViewStrategy implements DisplayViewStrategy {
    @Override
    public void sortSegnalazioni(@NotNull List<Segnalazione> segnalazioni) {
        segnalazioni.sort(Comparator.comparing(Segnalazione::data));
    }

    @Override
    public List<String> printSegnalazioni(@NotNull List<Segnalazione> segnalazioni) {
        List<String> s = new ArrayList<>();
        Map<String, Boolean> citta = new HashMap<>();
        for (Segnalazione segnalazione : segnalazioni) {
            if(!citta.containsKey(segnalazione.nomeCitta())){
                s.add(segnalazione.nomeCitta() + " " + segnalazione.criticity() + " " + segnalazione.data());
                citta.put(segnalazione.nomeCitta(), true);
            }
        }
        return s;
    }
}
