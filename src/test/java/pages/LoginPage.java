package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {
    private  final  By userNameInput = By.cssSelector("[id = 'user-name']");
    private  final  By passwordInput = By.cssSelector("[id = 'password']");
    private  final  By loginBtn = By.cssSelector("[id = 'login-button']");
    WebDriver driver;

    public LoginPage(WebDriver driver) {

        this.driver = driver;
    }
    public void open() {
        driver.get("https://www.saucedemo.com/");
    }
    public void Login(String user, String password) {
        driver.findElement(userNameInput).sendKeys(user);
        driver.findElement(passwordInput).sendKeys(password);
        driver.findElement(loginBtn).click();
    }

    public boolean isErrorVisible() {
        return driver.findElement(By.cssSelector("[data-test='error']")).isDisplayed();

    }
    public String getErrorText(){
        return driver.findElement(By.cssSelector("[data-test='error']")).getText();
    }
}
