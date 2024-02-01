package it.unimi.di.sweng.esame.presenter;

import it.unimi.di.sweng.esame.view.InputView;
import org.jetbrains.annotations.NotNull;

public class InputForecastPresenter implements InputPresenter{
    private final @NotNull InputView view;
    public InputForecastPresenter(@NotNull InputView view) {
        this.view = view;
    }

    @Override
    public void action(@NotNull String location, @NotNull String criticity, @NotNull String time) {
        if(location.isBlank()){
            view.showError("empty location name");
        }
    }
}
