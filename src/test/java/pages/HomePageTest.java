package pages;

import base.baseTest;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class HomePageTest extends baseTest {

    @Test
    public void consultarTexto1(){
        homePage.visitarPagina("https://automationexercise.com/signup");
        homePage.esperarTeimpoImplicito(6);
        assertEquals("Automation Exercise - Signup",homePage.obtenerTitulo());
    }

}