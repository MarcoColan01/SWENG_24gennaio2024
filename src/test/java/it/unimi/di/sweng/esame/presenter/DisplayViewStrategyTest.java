package it.unimi.di.sweng.esame.presenter;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class DisplayViewStrategyTest {

    @Test
    void testFirstViewStrategy(){
        DisplayViewStrategy SUT = new FirstViewStrategy();
        List<Segnalazione> segnalazioni = new ArrayList<>();
        Segnalazione s1 = new Segnalazione("Milano",
                Criticity.THUNDERSTORM,
                Data.creaData("02/05/2024"));
        Segnalazione s2 = new Segnalazione("Milano",
                Criticity.THUNDERSTORM,
                Data.creaData("01/05/2024"));
        Segnalazione s3 = new Segnalazione("Palermo",
                Criticity.THUNDERSTORM,
                Data.creaData("10/05/2024"));
        Segnalazione s4 = new Segnalazione("Palermo",
                Criticity.THUNDERSTORM,
                Data.creaData("17/05/2024"));
        segnalazioni.add(s1);
        segnalazioni.add(s2);
        segnalazioni.add(s3);
        segnalazioni.add(s4);
        SUT.sortSegnalazioni(segnalazioni);
        assertThat(SUT.printSegnalazioni(segnalazioni)).containsExactly("Milano THUNDERSTORM 01/05/2024",
                "Palermo THUNDERSTORM 10/05/2024");
    }

    @Test
    void testSecondViewStrategy(){
        DisplayViewStrategy SUT = new SecondViewStrategy();
        List<Segnalazione> segnalazioni = new ArrayList<>();
        Segnalazione s1 = new Segnalazione("Milano",
                Criticity.THUNDERSTORM,
                Data.creaData("02/05/2024"));
        Segnalazione s2 = new Segnalazione("Milano",
                Criticity.THUNDERSTORM,
                Data.creaData("01/05/2024"));
        Segnalazione s3 = new Segnalazione("Palermo",
                Criticity.THUNDERSTORM,
                Data.creaData("10/05/2024"));
        Segnalazione s4 = new Segnalazione("Palermo",
                Criticity.THUNDERSTORM,
                Data.creaData("17/05/2024"));
        segnalazioni.add(s1);
        segnalazioni.add(s2);
        segnalazioni.add(s3);
        segnalazioni.add(s4);
        SUT.sortSegnalazioni(segnalazioni);
        assertThat(segnalazioni).containsExactly(s2,s1,s3,s4);
    }

    @Test
    void testThirdViewStrategy(){
        DisplayViewStrategy SUT = new ThirdViewStrategy();
        List<Segnalazione> segnalazioni = new ArrayList<>();
        Segnalazione s1 = new Segnalazione("Milano",
                Criticity.THUNDERSTORM,
                Data.creaData("02/05/2024"));
        Segnalazione s2 = new Segnalazione("Milano",
                Criticity.RAINY,
                Data.creaData("01/05/2024"));
        Segnalazione s3 = new Segnalazione("Palermo",
                Criticity.CYCLONE,
                Data.creaData("10/05/2024"));
        Segnalazione s4 = new Segnalazione("Palermo",
                Criticity.HURRICANE,
                Data.creaData("17/05/2024"));
        segnalazioni.add(s1);
        segnalazioni.add(s2);
        segnalazioni.add(s3);
        segnalazioni.add(s4);
        SUT.sortSegnalazioni(segnalazioni);
        assertThat(segnalazioni).containsExactly(s3,s4,s1,s2);
    }
}