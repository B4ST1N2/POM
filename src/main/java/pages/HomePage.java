package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage extends commonActionPages{

    public HomePage(WebDriver driver) {
        super(driver);
    }

    By cajaBusqueda = By.xpath("//*[@id=\"ybar-sbq\"]");

    public void consultarTexto(String texto){
        limpiarCajaTexto(cajaBusqueda);
        escribirTexto(cajaBusqueda,texto);
        enviarTexto(cajaBusqueda);
    }

}
