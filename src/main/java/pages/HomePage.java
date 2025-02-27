package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class HomePage {

    private WebDriver driver;

    public HomePage(WebDriver driver) {
        this.driver = driver;
    }

    public String obtenerTitulo() {
        return driver.getTitle();
    }

    public void irALogin() {
        WebElement logInButton = driver.findElement(By.xpath("//*[@id=\"header\"]/div/div/div/div[2]/div/ul/li[4]/a"));
        logInButton.click();
    }

    public void ingresarTexto(By locator, String texto) {
        driver.findElement(locator).clear();
        driver.findElement(locator).sendKeys(texto);
    }

    public void oprimirBoton(By locator) {
        driver.findElement(locator).click();
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

    public void esperarTeimpoImplicito(int time) {
        driver.manage().timeouts().implicitlyWait(java.time.Duration.ofSeconds(time));
    }
}
