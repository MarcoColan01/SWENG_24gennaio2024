package it.unimi.di.sweng.esame.model;

import it.unimi.di.sweng.esame.presenter.Segnalazione;
import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Model {
    private final Map<String, List<Segnalazione>> segnalazioni = new HashMap<>();
    public void addSegnalazione(@NotNull Segnalazione segnalazione) {
        List<Segnalazione> s = new ArrayList<>();
        s.add(segnalazione);
        segnalazioni.put(segnalazione.nomeCitta(),s);
    }

    public List<Segnalazione> getSegnalazioni() {
        List<Segnalazione> s = new ArrayList<>();
        for(List<Segnalazione> segn: segnalazioni.values()){
            s.addAll(segn);
        }
        return new ArrayList<>(s);
    }
}
