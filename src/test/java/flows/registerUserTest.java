package flows;

import base.baseTest;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;


import java.time.Duration;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class registerUserTest extends baseTest {

    @Test
    public void register() {

        assertEquals("Automation Exercise", homePage.obtenerTitulo());

        WebElement logInButton = driver.findElement(By.xpath("//*[@id=\"header\"]/div/div/div/div[2]/div/ul/li[4]/a"));
        logInButton.click();
        WebElement userSignUpText = driver.findElement(By.xpath("//*[@id=\"form\"]/div/div/div[3]/div/h2"));
        assertEquals("New User Signup!", userSignUpText.getText());

        String userName = "root";
        homePage.ingresarTexto(By.xpath("//*[@id=\"form\"]/div/div/div[3]/div/form/input[2]"),userName);
        homePage.ingresarTexto(By.xpath("//*[@id=\"form\"]/div/div/div[3]/div/form/input[3]"),"root@root.co");
        homePage.oprimirBoton(By.xpath("//*[@id=\"form\"]/div/div/div[3]/div/form/button"));
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement accountInformation = driver.findElement(By.xpath("//*[@id=\"form\"]/div/div/div/div[1]/h2/b"));
        assertEquals("enter account information",accountInformation.getText().toLowerCase());

        WebElement titleMr = driver.findElement(By.xpath("//*[@id=\"id_gender1\"]"));
        titleMr.click();
        homePage.ingresarTexto(By.xpath("//*[@id=\"password\"]"),"root");

        WebElement dayDropdown = driver.findElement(By.id("days"));
        Select daySelect = new Select(dayDropdown);
        daySelect.selectByValue("15");  // Selecciona el día 15

        WebElement monthDropdown = driver.findElement(By.id("months"));
        Select monthSelect = new Select(monthDropdown);
        monthSelect.selectByValue("5");  // Selecciona el mes de mayo (5)


        WebElement yearDropdown = driver.findElement(By.id("years"));
        Select yearSelect = new Select(yearDropdown);
        yearSelect.selectByValue("1990");  // Selecciona el año 1990

        JavascriptExecutor js = (JavascriptExecutor) driver;

        WebElement newsletterCheck = driver.findElement(By.xpath("//*[@id=\"form\"]/div/div/div/div[1]/form/div[6]/label"));
        WebElement receiveOffersCheck = driver.findElement(By.xpath("//*[@id=\"form\"]/div/div/div/div[1]/form/div[7]/label"));

        js.executeScript("arguments[0].scrollIntoView(true);", receiveOffersCheck);
        newsletterCheck.click();
        receiveOffersCheck.click();


        homePage.ingresarTexto(By.xpath("//*[@id=\"first_name\"]"),"root");
        homePage.ingresarTexto(By.xpath("//*[@id=\"last_name\"]"),"root");
        homePage.ingresarTexto(By.xpath("//*[@id=\"company\"]"),"root");
        homePage.ingresarTexto(By.xpath("//*[@id=\"address1\"]"),"root");
        homePage.ingresarTexto(By.xpath("//*[@id=\"address2\"]"),"root");
        WebElement countryDropdown = driver.findElement(By.id("country"));
        Select countrySelect = new Select(countryDropdown);
        countrySelect.selectByValue("Canada");
        homePage.ingresarTexto(By.xpath("//*[@id=\"state\"]"),"root");
        homePage.ingresarTexto(By.xpath("//*[@id=\"city\"]"),"root");
        homePage.ingresarTexto(By.xpath("//*[@id=\"zipcode\"]"),"root");
        homePage.ingresarTexto(By.xpath("//*[@id=\"mobile_number\"]"),"root");
        homePage.oprimirBoton(By.xpath("//*[@id=\"form\"]/div/div/div/div/form/button"));

        WebElement accountCreated = driver.findElement(By.xpath("//*[@id=\"form\"]/div/div/div/h2/b"));
        assertEquals("account created!",accountCreated.getText().toLowerCase());
        homePage.oprimirBoton(By.xpath("//*[@id=\"form\"]/div/div/div/div/a"));

        WebElement loggedInAsNameButton = driver.findElement(By.xpath("//*[@id=\"header\"]/div/div/div/div[2]/div/ul/li[10]/a"));
        assertEquals("logged in as " + userName,loggedInAsNameButton.getText().toLowerCase().trim());

        homePage.oprimirBoton(By.xpath("//*[@id=\"header\"]/div/div/div/div[2]/div/ul/li[5]/a"));

        WebElement accountDeleted = driver.findElement(By.xpath("//*[@id=\"form\"]/div/div/div/h2/b"));
        assertEquals("account deleted!",accountDeleted.getText().toLowerCase());
    }
}
