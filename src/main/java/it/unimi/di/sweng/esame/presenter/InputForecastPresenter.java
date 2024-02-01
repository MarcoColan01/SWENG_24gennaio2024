package it.unimi.di.sweng.esame.presenter;

import it.unimi.di.sweng.esame.Main;
import it.unimi.di.sweng.esame.view.InputView;
import org.jetbrains.annotations.NotNull;

public class InputForecastPresenter implements InputPresenter{
    private final @NotNull InputView view;
    public InputForecastPresenter(@NotNull InputView view) {
        this.view = view;
        view.addHandlers(this);
    }

    @Override
    public void action(@NotNull String location, @NotNull String criticity, @NotNull String time) {
        try{
            Criticity c = Criticity.valueOf(criticity);
            Data data = Data.creaData(time);
            Segnalazione segnalazione = new Segnalazione(location, c, data);
            view.showSuccess();
        }catch(IllegalArgumentException e){
            if (e.getMessage().startsWith("No enum constant it.unimi.di.sweng.esame.presenter.Criticity."))
                view.showError("incorrect phenomena name");
            else{
                view.showError(e.getMessage());
                return;
            }

        }


    }
}
