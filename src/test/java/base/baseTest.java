package base;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.WebDriver;
import pages.HomePage;

public class baseTest {

    protected WebDriver driver;
    protected HomePage homePage;

    @BeforeEach
    public void setUp(){
        homePage = new HomePage(driver);
        driver = homePage.choromeDriverConexion();
        homePage.visitarPagina("https://automationexercise.com/");
    }

    @AfterEach
    public void tearDown(){
        driver.quit();
    }

}
