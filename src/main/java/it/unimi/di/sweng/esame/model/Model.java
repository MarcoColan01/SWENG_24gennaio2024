package it.unimi.di.sweng.esame.model;

import it.unimi.di.sweng.esame.Observable;
import it.unimi.di.sweng.esame.Observer;
import it.unimi.di.sweng.esame.presenter.Segnalazione;
import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Model implements Observable<List<Segnalazione>> {
    private final Map<String, List<Segnalazione>> segnalazioni = new HashMap<>();
    private final @NotNull List<Observer<List<Segnalazione>>> observers = new ArrayList<>();
    public void addSegnalazione(@NotNull Segnalazione segnalazione) {
        if(segnalazioni.containsKey(segnalazione.nomeCitta())){
            List<Segnalazione> s = segnalazioni.get(segnalazione.nomeCitta());
            for(Segnalazione app: s){
                if(app.data().compareTo(segnalazione.data()) == 0){
                    s.remove(app);
                    s.add(segnalazione);
                    notifyObservers();
                    return;
                }
            }
            segnalazioni.get(segnalazione.nomeCitta()).add(segnalazione);
        }else{
            List<Segnalazione> s = new ArrayList<>();
            s.add(segnalazione);
            segnalazioni.put(segnalazione.nomeCitta(),s);
        }
        notifyObservers();
    }

    public List<Segnalazione> getSegnalazioni(@NotNull String nomeCitta){
        return new ArrayList<>(segnalazioni.get(nomeCitta));
    }

    @Override
    public void notifyObservers() {
        for (Observer<List<Segnalazione>> observer : observers) {
            observer.update(this);
        }
    }

    @Override
    public void addObserver(@NotNull Observer<List<Segnalazione>> observer) {
        observers.add(observer);
    }

    @Override
    public List<Segnalazione> getState() {
        List<Segnalazione> s = new ArrayList<>();
        for(List<Segnalazione> segn: segnalazioni.values()){
            s.addAll(segn);
        }
        return new ArrayList<>(s);
    }
}
