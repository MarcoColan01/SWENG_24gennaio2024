package it.unimi.di.sweng.esame.presenter;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class DataTest {
    @Test
    void testNuovaData(){
        Data data = Data.creaData("08/12/2023");
        assertThat(data.toString()).isEqualTo("08/12/2023");
    }

    @ParameterizedTest
    @CsvSource({"08/12/2023, 09/12/2023, -1",
            "08/12/2023, 08/11/2023, 1",
            "08/12/2023, 08/12/2024, -1"
    })
    void testCompareData(String d1, String d2, String res){
        Data data1 = Data.creaData(d1);
        Data data2 = Data.creaData(d2);
        assertThat(data1.compareTo(data2)).isEqualTo(Integer.parseInt(res));
    }
}