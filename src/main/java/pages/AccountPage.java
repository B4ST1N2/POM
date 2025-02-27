package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class AccountPage {

    private WebDriver driver;

    public AccountPage(WebDriver driver) {
        this.driver = driver;
    }

    public boolean verificarCuentaCreada() {
        WebElement accountCreated = driver.findElement(By.xpath("//*[@id=\"form\"]/div/div/div/h2/b"));
        return accountCreated.getText().equalsIgnoreCase("account created!");
    }

    public void volverAlInicio(){
        WebElement botton= driver.findElement(By.xpath("//*[@id=\"form\"]/div/div/div/div/a"));
        botton.click();
    }

    public boolean verificarCuentaEliminada() {
        WebElement accountDeleted = driver.findElement(By.xpath("//*[@id=\"form\"]/div/div/div/h2/b"));
        return accountDeleted.getText().equalsIgnoreCase("account deleted!");
    }

    public void eliminarCuenta() {
        driver.findElement(By.xpath("//*[@id=\"header\"]/div/div/div/div[2]/div/ul/li[5]/a")).click();
    }
}
