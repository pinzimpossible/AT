package page;

import base.BasePage;
import base.readENV;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class featurePage extends BasePage {
    private final By SettingsP = By.xpath("//span[text()='Settings']");

    private final By FeatureDr = By.xpath("//a[text()='Feature customization']");

    private final By FeatureH = By.xpath("//span[text()='Feature customization']");

    private final By FeatureD = By.xpath("//div[contains(@class, 'gds-flex-direction-column')]/h3[contains(@class, 'gds-heading-small')]");

    public void openFeaturePage() {
        wait.until(ExpectedConditions.elementToBeClickable(SettingsP)).click();
        wait.until(ExpectedConditions.elementToBeClickable(FeatureDr)).click();
    }
    public boolean checkFeatureHeader () {
        String featureH = readENV.get("featureHeader");
        String webFeatureH = wait.until(ExpectedConditions.visibilityOfElementLocated(FeatureH)).getText();
        return featureH == webFeatureH;
    }

    public boolean checkFeatureDetail() {
        String featureD = readENV.get("featureDetail");
        String webFeatureD = wait.until(ExpectedConditions.visibilityOfElementLocated(FeatureD)).getText();
        return featureD == webFeatureD;
    }

}
