package it.unimi.di.sweng.esame.presenter;

import it.unimi.di.sweng.esame.model.Segnalazione;
import org.jetbrains.annotations.NotNull;

import java.util.List;

public interface DisplayViewStrategy {
    void sortSegnalazioni(@NotNull List<Segnalazione> segnalazioni);

    List<String> printSegnalazioni(List<Segnalazione> segnalazioni);
}
