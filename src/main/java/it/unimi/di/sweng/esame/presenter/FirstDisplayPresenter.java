package it.unimi.di.sweng.esame.presenter;

import it.unimi.di.sweng.esame.Observable;
import it.unimi.di.sweng.esame.Observer;
import it.unimi.di.sweng.esame.model.Model;
import it.unimi.di.sweng.esame.view.DisplayView;
import org.jetbrains.annotations.NotNull;

import java.util.List;

public class FirstDisplayPresenter implements Observer<List<Segnalazione>>{
    public FirstDisplayPresenter(DisplayView view, Model model, FirstViewStrategy firstViewStrategy) {
    }

    @Override
    public void update(@NotNull Observable<List<Segnalazione>> subject) {

    }
}
