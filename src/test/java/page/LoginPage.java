package page;

import base.BasePage;
import base.ReadEnv;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class LoginPage extends BasePage {

    private final By loginButton = By.xpath("//a[text()='Log in']");
    private final By emailField = By.id("email");
    private final By loginContinue = By.xpath("//button[@type='submit']");
    private final By passwordField = By.id("password");

    public void login() {

        String email = ReadEnv.get("email");
        String password = ReadEnv.get("password");

        wait.until(ExpectedConditions.elementToBeClickable(loginButton)).click();

        wait.until(ExpectedConditions.visibilityOfElementLocated(emailField)).sendKeys(email);
        wait.until(ExpectedConditions.elementToBeClickable(loginContinue)).click();

        wait.until(ExpectedConditions.visibilityOfElementLocated(passwordField)).sendKeys(password);
        wait.until(ExpectedConditions.elementToBeClickable(loginContinue)).click();
    }
}
