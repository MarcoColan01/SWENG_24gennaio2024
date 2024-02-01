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
        SUT.action("", "", "");
        verify(view).showError("empty location name");
    }

    @Test
    void testLocalityOk(){
        InputView view = mock(InputView.class);
        InputForecastPresenter SUT = new InputForecastPresenter(view);
        SUT.action("Milano", "RAINY", "");
        verify(view).showSuccess();
    }

    @Test
    void tesCriticityEmpty(){
        InputView view = mock(InputView.class);
        InputForecastPresenter SUT = new InputForecastPresenter(view);
        SUT.action("Milano", "", "");
        verify(view).showError("incorrect phenomena name");
    }

    @Test
    void tesCriticityWrong(){
        InputView view = mock(InputView.class);
        InputForecastPresenter SUT = new InputForecastPresenter(view);
        SUT.action("Milano", "APOCALIPSE", "");
        verify(view).showError("incorrect phenomena name");
    }

    @Test
    void tesCriticityOk(){
        InputView view = mock(InputView.class);
        InputForecastPresenter SUT = new InputForecastPresenter(view);
        SUT.action("Milano", "RAINY", "");
        verify(view).showSuccess();
    }
}