package page;

import base.BasePage;
import base.readENV;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class subscriptionPage extends BasePage {
    private final By subP = By.xpath("//span[text()='Subscription']");
    private final By subH = By.xpath("//h1[text()='Subscription']");
    private final By subD = By.cssSelector("._description_1sfw3_17]");

    public void openSubPage() {
        wait.until(ExpectedConditions.elementToBeClickable(subP)).click();
    }
    public boolean checkSubscriptionHeader () {
        String subHeader = readENV.get("subHeader");
        String webSubHeader = wait.until(ExpectedConditions.visibilityOfElementLocated(subH)).getText();
        return subHeader == webSubHeader;
    }

    public boolean checkSubscriptionDetail() {
        String subDetail = readENV.get("subDetail");
        String webSubDetail = wait.until(ExpectedConditions.visibilityOfElementLocated(subD)).getText();
        return subDetail == webSubDetail;
    }
}
