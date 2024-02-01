package it.unimi.di.sweng.esame.presenter;

import it.unimi.di.sweng.esame.model.Model;
import it.unimi.di.sweng.esame.view.DisplayView;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class FirstDisplayPresenterTest {
    @Test
    void testUpdateFirstPresenter(){
        DisplayView view = mock(DisplayView.class);
        Model model = spy(Model.class);
        FirstDisplayPresenter SUT = new FirstDisplayPresenter(view, model, new FirstViewStrategy());
        model.addSegnalazione(new Segnalazione("Milano", Criticity.HURRICANE, Data.creaData("02/05/2024")));
        verify(view).set(0, "Milano HURRICANE 02/05/2024");
    }

    /*@Test
    void testUpdateFirstPresenter2(){
        DisplayView view = mock(DisplayView.class);
        Model model = spy(Model.class);
        FirstDisplayPresenter SUT = new FirstDisplayPresenter(view, model, new FirstViewStrategy());
        model.addSegnalazione(new Segnalazione("Milano", Criticity.HURRICANE, Data.creaData("02/05/2024")));
        model.addSegnalazione(new Segnalazione("Palermo", Criticity.HURRICANE, Data.creaData("10/05/2024")));
        verify(view, times(1)).set(0, "Milano HURRICANE 02/05/2024");
        verify(view, times(1)).set(1, "Palermo HURRICANE 10/05/2024");
    }*/
}