package page;

import base.BasePage;
import base.readENV;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class profilePage extends BasePage {
    private final By profileHeader = By.xpath("//h1[text()='Profile']");

    private final By accountName = By.cssSelector("p[data-qa='Name-Value']");

    private final By accountEmail = By.cssSelector("p[data-qa='Email-Value']");

    public boolean checkProfileHeader () {
        String pH = readENV.get("pH");
        String webPH = wait.until(ExpectedConditions.visibilityOfElementLocated(profileHeader)).getText();
        return pH == webPH;
    }

    public boolean checkAccountName () {
        String aN = readENV.get("name");
        String webAN = wait.until(ExpectedConditions.visibilityOfElementLocated(accountName)).getText();
        return aN == webAN;
    }

    public boolean checkAccountEmail () {
        String aE = readENV.get("email");
        String webAE = wait.until(ExpectedConditions.visibilityOfElementLocated(accountEmail)).getText();
        return aE == webAE;
    }
}
