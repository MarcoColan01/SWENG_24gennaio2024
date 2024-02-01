package it.unimi.di.sweng.esame.model;

import it.unimi.di.sweng.esame.model.Criticity;
import it.unimi.di.sweng.esame.model.Data;
import org.jetbrains.annotations.NotNull;

public record Segnalazione(@NotNull String nomeCitta, @NotNull Criticity criticity, @NotNull Data data) {
        public Segnalazione{
            if(nomeCitta.isBlank()) throw new IllegalArgumentException("empty location name");
        }
}
