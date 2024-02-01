package it.unimi.di.sweng.esame.presenter;

import it.unimi.di.sweng.esame.Main;
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
            return;
        }
        if(criticity.isBlank()){
            view.showError("incorrect phenomena name");
            return;
        }
        try{
            Criticity c = Criticity.valueOf(criticity);
        }catch(IllegalArgumentException e){
            view.showError("incorrect phenomena name");
            return;
        }
        if(!time.matches("^(0[1-9]|[12][0-9]|3[01])/(0[1-9]|1[0-2])/(\\d{4})$")){
            view.showError("incorrect data format (correct format: dd/mm/yyyy)");
            return;
        }
        Data data = Data.creaData(time);
        if(data.compareTo(Main.DATA) < 0){
            view.showError("forecast date cannot be in the past");
            return;
        }
        view.showSuccess();
    }
}
