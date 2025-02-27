package flows;

import base.baseTest;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import pages.LoginPage;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class logoutUserTest extends baseTest {

    @Test
    public void logoutUser() {
        // Aseguramos que estamos en la página de inicio
        assertEquals("Automation Exercise", homePage.obtenerTitulo());

        // Creamos una instancia de la clase LoginPage para manejar el login
        LoginPage loginPage = new LoginPage(driver);

        // Ir a la página de login
        homePage.irALogin();

        // Verificamos que estamos en la página de login
        assertEquals("Login to your account", driver.findElement(By.xpath("//*[@id=\"form\"]/div/div/div[1]/div[1]/h2")).getText());

        // Ingresar credenciales y hacer login
        loginPage.ingresarCredenciales("root@root.com", "root");
        loginPage.hacerLogin();

        // Verificamos que el usuario está logueado
        assertEquals("logged in as root", loginPage.obtenerTextoLogin());

        // Hacemos logout
        loginPage.hacerLogout();

        // Verificamos que estamos de vuelta en la página de login
        assertEquals("Automation Exercise - Signup / Login", loginPage.obtenerTextoPagina());
    }
}
