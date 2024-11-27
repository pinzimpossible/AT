package page;

import base.BasePage;
import base.readENV;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class loginPage extends BasePage {

    private final By loginButton = By.xpath("//a[text()='Log in']");
    private final By emailField = By.id("email");
    private final By loginContinue = By.xpath("//button[@type='submit']");
    private final By passwordField = By.id("password");

    public void openLoginPage() {
        driver.get(readENV.get("env"));
    }

    public void login() {

        String email = readENV.get("email");
        String password = readENV.get("password");

        wait.until(ExpectedConditions.elementToBeClickable(loginButton)).click();

        wait.until(ExpectedConditions.visibilityOfElementLocated(emailField)).sendKeys(email);
        wait.until(ExpectedConditions.elementToBeClickable(loginContinue)).click();

        wait.until(ExpectedConditions.visibilityOfElementLocated(passwordField)).sendKeys(password);
        wait.until(ExpectedConditions.elementToBeClickable(loginContinue)).click();
    }
}
