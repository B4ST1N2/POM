package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.JavascriptExecutor;

public class ProductPage {

    private WebDriver driver;
    private HomePage homePage;

    public ProductPage(WebDriver driver) {
        this.driver = driver;
        this.homePage = new HomePage(driver);
    }

    public void verProducto() {
        WebElement viewProduct = driver.findElement(By.xpath("/html/body/section[2]/div/div/div[2]/div/div[3]/div/div[2]/ul/li/a"));
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView(true);", viewProduct);
        viewProduct.click();
    }

    public void esperarYVerEscribirComentario() {
        WebElement writeYourReviewText = driver.findElement(By.xpath("/html/body/section/div/div/div[2]/div[3]/div[1]/ul/li/a"));
        JavascriptExecutor js = (JavascriptExecutor) driver;

        while (!writeYourReviewText.isDisplayed()) {
            js.executeScript("window.scrollBy(0, 500);");
        }
    }

    public void ingresarComentario(String nombre, String email, String comentario) {
        homePage.ingresarTexto(By.xpath("//*[@id=\"name\"]"), nombre);
        homePage.ingresarTexto(By.xpath("//*[@id=\"email\"]"), email);
        homePage.ingresarTexto(By.xpath("//*[@id=\"review\"]"), comentario);
    }

    public void enviarComentario() {
        WebElement submitButton = driver.findElement(By.xpath("//*[@id=\"button-review\"]"));
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView(true);", submitButton);
        submitButton.click();
    }


    public String obtenerMensajeGracias() {
        WebElement messageThankYou = driver.findElement(By.xpath("//*[@id=\"review-section\"]/div/div/span"));
        return messageThankYou.getText();
    }
}
