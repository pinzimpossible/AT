package page;

import base.BasePage;
import base.readENV;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class writingPage extends BasePage {
    private final By WritingP = By.xpath("//span[text()='Writing']");

    private final By WritingDr = By.xpath("//a[text()='Your dictionary']");

    private final By WritingH = By.xpath("//span[text()='Your dictionary']");

    private final By WritingD1 = By.xpath("//div[contains(@class, 'gds-flex-direction-column')]/p[contains(@class, 'gds-text-small')][1]");
    private final By WritingD2 = By.xpath("//div[contains(@class, 'gds-flex-direction-column')]/p[contains(@class, 'gds-text-small')][2]");

    public void openWritingPage() {
        wait.until(ExpectedConditions.elementToBeClickable(WritingP)).click();
        wait.until(ExpectedConditions.elementToBeClickable(WritingDr)).click();
    }
    public boolean checkWritingHeader () {
        String writingH = readENV.get("dictionaryHeader");
        String webWritingH = wait.until(ExpectedConditions.visibilityOfElementLocated(WritingH)).getText();
        return writingH == webWritingH;
    }

    public boolean checkWritingDetail() {
        String writingD1 = readENV.get("dictionaryDetail1");
        String writingD2 = readENV.get("dictionaryDetail2");
        String webWritingD1 = wait.until(ExpectedConditions.visibilityOfElementLocated(WritingD1)).getText();
        String webWritingD2 = wait.until(ExpectedConditions.visibilityOfElementLocated(WritingD2)).getText();

        return writingD1 == webWritingD1 && writingD2 == webWritingD2;
    }

}
