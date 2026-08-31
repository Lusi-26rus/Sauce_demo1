package tests;

import org.testng.annotations.Test;
import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class DzLoginTest extends BaseTest {

    @Test
    public void testLockedOutUserLogin() {

        loginPage.open();
        loginPage.Login("locked_out_user", "secret_sauce");

        boolean isVisible = loginPage.isErrorVisible();
        String errorText = loginPage.getErrorText();

        assertTrue(isVisible);
        assertEquals(errorText, "Epic sadface: Sorry, this user has been locked out.");
    }

    @Test
    public void correctUserTest(){

        loginPage.open();
        loginPage.Login("standard_user", "secret_sauce");

        boolean pageTitleVisible = productsPage.isPageTitleVisible();
        assertTrue(pageTitleVisible);

        assertEquals(productsPage.getPageTitle(), "Products");
    }

    @Test
    public void NoLoginTest(){
        loginPage.open();
        loginPage.Login("", "secret_sauce");

        boolean isVisible = loginPage.isErrorVisible();
        String errorText = loginPage.getErrorText();

        assertTrue(isVisible);
        assertEquals(errorText, "Epic sadface: Username is required");
    }

    @Test
    public void NoPasswordTest(){
        loginPage.open();
        loginPage.Login("standard_user", "");

        boolean isVisible = loginPage.isErrorVisible();
        String errorText = loginPage.getErrorText();

        assertTrue(isVisible);
        assertEquals(errorText, "Epic sadface: Password is required");
    }

    @Test
    public void NoCorrectUserTest(){
        loginPage.open();
        loginPage.Login("Standard_user", "secret_sauce");

        boolean isVisible = loginPage.isErrorVisible();
        String errorText = loginPage.getErrorText();

        assertTrue(isVisible);
        assertEquals(errorText, "Epic sadface: Username and password do not match any user in this service");
    }
}
