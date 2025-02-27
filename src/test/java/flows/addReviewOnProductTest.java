package flows;

import base.baseTest;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import pages.ProductPage;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class addReviewOnProductTest extends baseTest {

    @Test
    public void addReviewOnProduct() {

        homePage.oprimirBoton(By.xpath("//*[@id=\"header\"]/div/div/div/div[2]/div/ul/li[2]/a"));
        assertEquals("Automation Exercise - All Products", homePage.obtenerTitulo());

        ProductPage productPage = new ProductPage(driver);

        productPage.verProducto();

        productPage.esperarYVerEscribirComentario();

        productPage.ingresarComentario("root", "root@root.com", "root");

        productPage.enviarComentario();

        assertEquals("Thank you for your review.", productPage.obtenerMensajeGracias());
    }
}
