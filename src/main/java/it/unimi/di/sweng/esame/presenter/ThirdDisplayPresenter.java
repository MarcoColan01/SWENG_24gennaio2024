package it.unimi.di.sweng.esame.presenter;

import it.unimi.di.sweng.esame.Main;
import it.unimi.di.sweng.esame.Observable;
import it.unimi.di.sweng.esame.Observer;
import it.unimi.di.sweng.esame.model.Model;
import it.unimi.di.sweng.esame.view.DisplayView;
import org.jetbrains.annotations.NotNull;

import java.util.List;

public class ThirdDisplayPresenter implements Observer<List<Segnalazione>> {
    private final @NotNull DisplayView view;
    private final @NotNull Model model;
    private final @NotNull DisplayViewStrategy strategy;
    public ThirdDisplayPresenter(@NotNull DisplayView view, @NotNull Model model,
                                 @NotNull DisplayViewStrategy strategy) {
        this.model = model;
        this.strategy = strategy;
        this.view = view;
        model.addObserver(this);
    }

    @Override
    public void update(@NotNull Observable<List<Segnalazione>> subject) {
        int i = 0;
        strategy.sortSegnalazioni(subject.getState());
        for(String segnalazione: strategy.printSegnalazioni(subject.getState())){
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
