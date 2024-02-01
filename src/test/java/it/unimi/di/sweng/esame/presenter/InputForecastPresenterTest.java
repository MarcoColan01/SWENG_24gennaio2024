package it.unimi.di.sweng.esame.presenter;

import it.unimi.di.sweng.esame.view.InputView;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

class InputForecastPresenterTest {

    @Test
    void testLocalityEmpty(){
        InputView view = mock(InputView.class);
        InputForecastPresenter SUT = new InputForecastPresenter(view);
        SUT.action("", "RAINY", "01/10/2024");
        verify(view).showError("empty location name");
    }

    @Test
    void testLocalityOk(){
        InputView view = mock(InputView.class);
        InputForecastPresenter SUT = new InputForecastPresenter(view);
        SUT.action("Milano", "RAINY", "01/10/2024");
        verify(view).showSuccess();
    }

    @Test
    void tesCriticityEmpty(){
        InputView view = mock(InputView.class);
        InputForecastPresenter SUT = new InputForecastPresenter(view);
        SUT.action("Milano", "", "01/10/2024");
        verify(view).showError("incorrect phenomena name");
    }

    @Test
    void tesCriticityWrong(){
        InputView view = mock(InputView.class);
        InputForecastPresenter SUT = new InputForecastPresenter(view);
        SUT.action("Milano", "APOCALIPSE", "01/10/2024");
        verify(view).showError("incorrect phenomena name");
    }

    @Test
    void tesCriticityOk(){
        InputView view = mock(InputView.class);
        InputForecastPresenter SUT = new InputForecastPresenter(view);
        SUT.action("Milano", "RAINY", "01/10/2024");
        verify(view).showSuccess();
    }

    @Test
    void testDateFormatIncorrect(){
        InputView view = mock(InputView.class);
        InputForecastPresenter SUT = new InputForecastPresenter(view);
        SUT.action("Milano", "RAINY", "1/10/2024");
        verify(view).showError("incorrect data format (correct format: dd/mm/yyyy)");
    }

    @Test
    void testDateNotFuture(){
        InputView view = mock(InputView.class);
        InputForecastPresenter SUT = new InputForecastPresenter(view);
        SUT.action("Milano", "RAINY", "01/10/2023");
        verify(view).showError("forecast date cannot be in the past");
    }
}