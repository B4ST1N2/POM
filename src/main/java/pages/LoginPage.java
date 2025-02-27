package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;


public class LoginPage {

    private WebDriver driver;
    private HomePage homePage;

    public LoginPage(WebDriver driver) {
        this.driver = driver;
        this.homePage = new HomePage(driver);
    }

    public void ingresarCredenciales(String email, String password) {
        homePage.ingresarTexto(By.xpath("//*[@id=\"form\"]/div/div/div[1]/div[1]/form/input[2]"), email);
        homePage.ingresarTexto(By.xpath("//*[@id=\"form\"]/div/div/div[1]/div[1]/form/input[3]"), password);
    }

    public void hacerLogin() {
        homePage.oprimirBoton(By.xpath("//*[@id=\"form\"]/div/div/div[1]/div[1]/form/button"));
    }

    public String obtenerTextoLogin() {
        WebElement loggedInAsNameButton = driver.findElement(By.xpath("//*[@id=\"header\"]/div/div/div/div[2]/div/ul/li[10]/a"));
        return loggedInAsNameButton.getText().toLowerCase().trim();
    }

    public void hacerLogout() {
        homePage.oprimirBoton(By.xpath("//*[@id=\"header\"]/div/div/div/div[2]/div/ul/li[4]/a"));
    }

    public String obtenerTextoPagina() {
        return homePage.obtenerTitulo();
    }
}
