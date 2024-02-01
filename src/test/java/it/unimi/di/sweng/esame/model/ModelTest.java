package it.unimi.di.sweng.esame.model;

import it.unimi.di.sweng.esame.presenter.Criticity;
import it.unimi.di.sweng.esame.presenter.Data;
import it.unimi.di.sweng.esame.presenter.Segnalazione;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class ModelTest {

    @Test
    void testAddSegnalazione(){
        Model SUT = new Model();
        SUT.addSegnalazione(new Segnalazione("Milano", Criticity.RAINY, Data.creaData("02/05/2024")));
        assertThat(SUT.getSegnalazioni()).hasSize(1);
    }
}