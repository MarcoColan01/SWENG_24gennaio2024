package it.unimi.di.sweng.esame.presenter;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class DataTest {
    @Test
    void testNuovaData(){
        Data data = Data.creaData("08/12/2023");
        assertThat(data.toString()).isEqualTo("08/12/2023");
    }
}