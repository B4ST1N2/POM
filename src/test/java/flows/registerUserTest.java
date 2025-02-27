package flows;

import base.baseTest;
import org.junit.jupiter.api.Test;
import pages.AccountPage;
import pages.RegisterPage;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class registerUserTest extends baseTest {

    @Test
    public void register() {
        assertEquals("Automation Exercise", homePage.obtenerTitulo());

        // Navegar a la página de login y registrarse
        homePage.irALogin();

        String userName = "root";
        RegisterPage registerPage = new RegisterPage(driver);
        registerPage.completarFormularioRegistro(userName);

        // Ingresar detalles de cuenta
        registerPage.ingresarInformacionCuenta();

        // Verificar que la cuenta fue creada correctamente
        AccountPage accountPage = new AccountPage(driver);
        assertTrue(accountPage.verificarCuentaCreada());
        accountPage.volverAlInicio();

        // Eliminar cuenta y verificar si se eliminó
        accountPage.eliminarCuenta();
        assertTrue(accountPage.verificarCuentaEliminada());
    }
}
