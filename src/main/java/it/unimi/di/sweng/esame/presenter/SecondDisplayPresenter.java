package it.unimi.di.sweng.esame.presenter;

import it.unimi.di.sweng.esame.Main;
import it.unimi.di.sweng.esame.Observer;
import it.unimi.di.sweng.esame.model.Model;
import it.unimi.di.sweng.esame.model.Segnalazione;
import it.unimi.di.sweng.esame.view.DisplayView;
import org.jetbrains.annotations.NotNull;

import java.util.List;

public class SecondDisplayPresenter implements Observer<List<Segnalazione>> {
    private final @NotNull DisplayView view;
    private final @NotNull Model model;
    private final @NotNull DisplayViewStrategy strategy;
    public SecondDisplayPresenter(@NotNull DisplayView view, @NotNull Model model,
                                  @NotNull DisplayViewStrategy strategy) {
        this.model = model;
        this.strategy = strategy;
        this.view = view;
        model.addObserver(this);
    }

    @Override
    public void update(@NotNull List<Segnalazione> state) {
        int i = 0;
        strategy.sortSegnalazioni(state);
        for(String segnalazione: strategy.printSegnalazioni(state)){
            view.set(i++, segnalazione);
            if(i >= Main.SIZEVIEW) return;
        }
        if(i < Main.SIZEVIEW){
            for(int j = i; j < Main.SIZEVIEW; j++){
                view.set(j, "");
            }
        }
    }
}