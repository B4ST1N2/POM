package flows;

import base.baseTest;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class logoutUserTest extends baseTest {

   @Test
   public void logoutUser() {
       assertEquals("Automation Exercise",homePage.obtenerTitulo());

       WebElement logInButton = driver.findElement(By.xpath("//*[@id=\"header\"]/div/div/div/div[2]/div/ul/li[4]/a"));
       logInButton.click();

       WebElement loginText = driver.findElement(By.xpath("//*[@id=\"form\"]/div/div/div[1]/div[1]/h2"));
       assertEquals("Login to your account", loginText.getText());

       homePage.ingresarTexto(By.xpath("//*[@id=\"form\"]/div/div/div[1]/div[1]/form/input[2]"),"root@root.com");
       homePage.ingresarTexto(By.xpath("//*[@id=\"form\"]/div/div/div[1]/div[1]/form/input[3]"),"root");
       homePage.oprimirBoton(By.xpath("//*[@id=\"form\"]/div/div/div[1]/div[1]/form/button"));

       WebElement loggedInAsNameButton = driver.findElement(By.xpath("//*[@id=\"header\"]/div/div/div/div[2]/div/ul/li[10]/a"));
       assertEquals("logged in as root",loggedInAsNameButton.getText().toLowerCase().trim());

       homePage.oprimirBoton(By.xpath("//*[@id=\"header\"]/div/div/div/div[2]/div/ul/li[4]/a"));

       assertEquals("Automation Exercise - Signup / Login",homePage.obtenerTitulo());
   }
}
