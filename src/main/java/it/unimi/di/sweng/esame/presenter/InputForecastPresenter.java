package it.unimi.di.sweng.esame.presenter;

import it.unimi.di.sweng.esame.model.Criticity;
import it.unimi.di.sweng.esame.model.Data;
import it.unimi.di.sweng.esame.model.Model;
import it.unimi.di.sweng.esame.model.Segnalazione;
import it.unimi.di.sweng.esame.view.InputView;
import org.jetbrains.annotations.NotNull;

public class InputForecastPresenter implements InputPresenter{
    private final @NotNull InputView view;
    private final @NotNull Model model;
    public InputForecastPresenter(@NotNull InputView view, @NotNull Model model) {
        this.view = view;
        this.model = model;
        view.addHandlers(this);
    }

    @Override
    public void action(@NotNull String location, @NotNull String criticity, @NotNull String time) {
        try{
            Criticity c = Criticity.valueOf(criticity);
            Data data = Data.creaData(time);
            Segnalazione segnalazione = new Segnalazione(location, c, data);
            model.addSegnalazione(segnalazione);
            view.showSuccess();
        }catch(IllegalArgumentException e){
            if (e.getMessage().startsWith("No enum constant it.unimi.di.sweng.esame.model.Criticity."))
                view.showError("incorrect phenomena name");
            else{
                view.showError(e.getMessage());
                return;
            }

        }


    }
}
