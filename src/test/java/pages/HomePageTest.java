package pages;

import base.baseTest;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class HomePageTest extends baseTest {

    @Test
    public void consultarTexto1(){
        homePage.consultarTexto("SmartFit");
        homePage.esperarTeimpoImplicito(6);
        assertEquals("SmartFit - Yahoo Search Tus resultados",homePage.obtenerTitulo());
    }

}