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

        homePage.irALogin();

        String userName = "root";
        RegisterPage registerPage = new RegisterPage(driver);
        registerPage.completarFormularioRegistro(userName);

        registerPage.ingresarInformacionCuenta();

        AccountPage accountPage = new AccountPage(driver);
        assertTrue(accountPage.verificarCuentaCreada());
        accountPage.volverAlInicio();

        accountPage.eliminarCuenta();
        assertTrue(accountPage.verificarCuentaEliminada());
    }
}
