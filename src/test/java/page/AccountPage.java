package page;

import base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class accountPage extends BasePage {
    private final By action = By.cssSelector("a[data-name='account-lnk']");

    public void action(){
        wait.until(ExpectedConditions.elementToBeClickable(action)).click();

    }
}
