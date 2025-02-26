package flows;

import base.baseTest;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class addReviewOnProductTest extends baseTest {

    @Test
    public void addReviewOnProduct() {
        homePage.oprimirBoton(By.xpath("//*[@id=\"header\"]/div/div/div/div[2]/div/ul/li[2]/a"));
        assertEquals("Automation Exercise - All Products",homePage.obtenerTitulo());

        WebElement viewProduct = driver.findElement(By.xpath("/html/body/section[2]/div/div/div[2]/div/div[3]/div/div[2]/ul/li/a"));

        JavascriptExecutor js = (JavascriptExecutor) driver;

        js.executeScript("arguments[0].scrollIntoView(true);", viewProduct);
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.elementToBeClickable(viewProduct));

        viewProduct.click();

        WebElement WriteYourReviewText = driver.findElement(By.xpath("/html/body/section/div/div/div[2]/div[3]/div[1]/ul/li/a"));

        while (!WriteYourReviewText.isDisplayed()) {
            js.executeScript("window.scrollBy(0, 500);");
        }

        assertEquals("write your review",WriteYourReviewText.getText().toLowerCase());
        homePage.ingresarTexto(By.xpath("//*[@id=\"name\"]"),"root");
        homePage.ingresarTexto(By.xpath("//*[@id=\"email\"]"),"root@root.com");
        homePage.ingresarTexto(By.xpath("//*[@id=\"review\"]"),"root");

        WebElement submitButton = driver.findElement(By.xpath("//*[@id=\"button-review\"]"));
        js.executeScript("arguments[0].scrollIntoView(true);", submitButton);
        submitButton.click();

        WebElement messageThankYou = driver.findElement(By.xpath("//*[@id=\"review-section\"]/div/div/span"));
        assertEquals("Thank you for your review.",messageThankYou.getText());
    }
}
