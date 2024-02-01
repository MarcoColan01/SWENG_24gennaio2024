package it.unimi.di.sweng.esame.presenter;

import it.unimi.di.sweng.esame.model.Segnalazione;
import org.jetbrains.annotations.NotNull;

import java.util.*;

public class FirstDisplayStrategy implements DisplayViewStrategy {
    @Override
    public void sortSegnalazioni(@NotNull List<Segnalazione> segnalazioni) {
        segnalazioni.sort(Comparator.comparing(Segnalazione::data));
        System.out.println(segnalazioni);
    }

    @Override
    public List<String> printSegnalazioni(@NotNull List<Segnalazione> segnalazioni) {
        List<String> s = new ArrayList<>();
        Map<String, Boolean> citta = new HashMap<>();
        sortSegnalazioni(segnalazioni);
        for (Segnalazione segnalazione : segnalazioni) {
            if(!citta.containsKey(segnalazione.nomeCitta())){
                s.add(segnalazione.nomeCitta() + " " + segnalazione.criticity() + " " + segnalazione.data());
                citta.put(segnalazione.nomeCitta(), true);
            }
        }
        return s;
    }
}
