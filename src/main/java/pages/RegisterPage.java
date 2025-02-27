package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class RegisterPage {

    private WebDriver driver;

    public RegisterPage(WebDriver driver) {
        this.driver = driver;
    }

    public void completarFormularioRegistro(String userName) {
        driver.findElement(By.xpath("//*[@id=\"form\"]/div/div/div[3]/div/form/input[2]")).sendKeys(userName);
        driver.findElement(By.xpath("//*[@id=\"form\"]/div/div/div[3]/div/form/input[3]")).sendKeys("root@root.gob");
        driver.findElement(By.xpath("//*[@id=\"form\"]/div/div/div[3]/div/form/button")).click();
    }

    public void ingresarInformacionCuenta() {
        driver.findElement(By.xpath("//*[@id=\"id_gender1\"]")).click();
        driver.findElement(By.xpath("//*[@id=\"password\"]")).sendKeys("root");

        seleccionarFechaNacimiento("15", "5", "1990");
        seleccionarCheckboxes();
        completarDatosPersonales();
    }

    private void seleccionarFechaNacimiento(String dia, String mes, String año) {
        Select daySelect = new Select(driver.findElement(By.id("days")));
        daySelect.selectByValue(dia);

        Select monthSelect = new Select(driver.findElement(By.id("months")));
        monthSelect.selectByValue(mes);

        Select yearSelect = new Select(driver.findElement(By.id("years")));
        yearSelect.selectByValue(año);
    }

    private void seleccionarCheckboxes() {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        WebElement newsletterCheck = driver.findElement(By.xpath("//*[@id=\"form\"]/div/div/div/div[1]/form/div[6]/label"));
        WebElement receiveOffersCheck = driver.findElement(By.xpath("//*[@id=\"form\"]/div/div/div/div[1]/form/div[7]/label"));

        js.executeScript("arguments[0].scrollIntoView(true);", receiveOffersCheck);
        newsletterCheck.click();
        receiveOffersCheck.click();
    }

    private void completarDatosPersonales() {
        driver.findElement(By.xpath("//*[@id=\"first_name\"]")).sendKeys("root");
        driver.findElement(By.xpath("//*[@id=\"last_name\"]")).sendKeys("root");
        driver.findElement(By.xpath("//*[@id=\"company\"]")).sendKeys("root");
        driver.findElement(By.xpath("//*[@id=\"address1\"]")).sendKeys("root");
        driver.findElement(By.xpath("//*[@id=\"address2\"]")).sendKeys("root");

        Select countrySelect = new Select(driver.findElement(By.id("country")));
        countrySelect.selectByValue("Canada");

        driver.findElement(By.xpath("//*[@id=\"state\"]")).sendKeys("root");
        driver.findElement(By.xpath("//*[@id=\"city\"]")).sendKeys("root");
        driver.findElement(By.xpath("//*[@id=\"zipcode\"]")).sendKeys("root");
        driver.findElement(By.xpath("//*[@id=\"mobile_number\"]")).sendKeys("root");
        driver.findElement(By.xpath("//*[@id=\"form\"]/div/div/div/div/form/button")).click();
    }
}
