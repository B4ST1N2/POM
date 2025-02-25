package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.WebElement;

import java.time.Duration;

public class commonActionPages {

    protected WebDriver driver;

    public commonActionPages(WebDriver driver) {
        this.driver = driver;
    }

    public WebDriver choromeDriverConexion(){
        System.setProperty("webdriver.chrome.driver", "./src/test/resources/chromedriver/chromedriver.exe");
        driver = new ChromeDriver();
        return driver;
    }

    public void visitarPagina(String enlace){
        driver.get(enlace);
        driver.manage().window().maximize();
    }

    public void limpiarCajaTexto(By localizador){
        driver.findElement(localizador).clear();
    }

    public void escribirTexto(By localizador, String texto){
        driver.findElement(localizador).sendKeys(texto);
    }

    public void enviarTexto(By localizador){
        driver.findElement(localizador).submit();
    }

    public void esperarTeimpoImplicito(int time){
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(time));
    }

    public String obtenerTitulo(){
        return driver.getTitle();
    }

    public void ingresarTexto(By localizador,String texto){
        driver.findElement(localizador).clear();
        driver.findElement(localizador).sendKeys(texto);
    }

    public void oprimirBoton(By localizador){
        WebElement button = driver.findElement(localizador);
        button.click();
    }
}
