package main.test;

import base.BasePage;
import base.ReadEnv;

import page.AccountPage;
import page.ProfilePage;
import page.SubscriptionPage;
import page.WritingPage;
import page.FeaturePage;

import org.openqa.selenium.TakesScreenshot;
import org.testng.Assert;
import org.openqa.selenium.OutputType;
import org.testng.annotations.*;
import io.qameta.allure.*;
import org.testng.ITestResult;

@Listeners(io.qameta.allure.testng.AllureTestNg.class)
public class CheckItemsInAccountPage {

    //Run before Test
    @BeforeSuite
    private void setUp() {
        ReadEnv.loadProperties("STG");
        LoginGrammarly.executeLoginTest();
        AccountPage accountpage = new AccountPage();
        accountpage.action();
    }

    @Test
    @Description("Verify elements on the Profile Page")
    @Severity(SeverityLevel.CRITICAL)
    public void checkProfilePage() {
        executeTest(() -> {
            ProfilePage profilePage = new ProfilePage();
            verifyProfileHeader(profilePage);
            verifyAccountName(profilePage);
            verifyAccountEmail(profilePage);
        });
    }

    @Step("Verify profile header")
    private void verifyProfileHeader(ProfilePage profilePage) {
        Assert.assertTrue(profilePage.checkProfileHeader(), "Profile header is incorrect.");
    }

    @Step("Verify account name")
    private void verifyAccountName(ProfilePage profilePage) {
        Assert.assertTrue(profilePage.checkAccountName(), "Account name is incorrect.");
    }

    @Step("Verify account email")
    private void verifyAccountEmail(ProfilePage profilePage) {
        Assert.assertTrue(profilePage.checkAccountEmail(), "Account email is incorrect.");
    }

    @Test
    @Description("Verify elements on the Subscription Page")
    @Severity(SeverityLevel.CRITICAL)
    public void checkSubscriptionPage() {
        executeTest(() -> {
            SubscriptionPage subscriptionPage = new SubscriptionPage();
            subscriptionPage.openSubPage();
            verifySubscriptionHeader(subscriptionPage);
            verifySubscriptionDetails(subscriptionPage);
        });
    }

    @Step("Verify Subscription header")
    private void verifySubscriptionHeader(SubscriptionPage subscriptionPage) {
        Assert.assertTrue(subscriptionPage.checkSubscriptionHeader(), "Subscription header is incorrect.");
    }

    @Step("Verify Subscription details")
    private void verifySubscriptionDetails(SubscriptionPage subscriptionPage) {
        Assert.assertTrue(subscriptionPage.checkSubscriptionDetail(), "Subscription details are incorrect.");
    }

    @Test
    @Description("Verify elements on the Writing Page")
    @Severity(SeverityLevel.CRITICAL)
    public void checkWritingPage() {
        executeTest(() -> {
            WritingPage writingPage = new WritingPage();
            writingPage.openWritingPage();
            verifyWritingHeader(writingPage);
            verifyWritingDetails(writingPage);
        });
    }

    @Step("Verify Writing header")
    private void verifyWritingHeader(WritingPage writingPage) {
        Assert.assertTrue(writingPage.checkWritingHeader(), "Writing page header is incorrect.");
    }

    @Step("Verify Writing details")
    private void verifyWritingDetails(WritingPage writingPage) {
        Assert.assertTrue(writingPage.checkWritingDetail(), "Writing page details are incorrect.");
    }

    @Test
    @Description("Verify elements on the Feature Page")
    @Severity(SeverityLevel.CRITICAL)
    public void checkFeaturePage() {
        executeTest(() -> {
            FeaturePage featurePage = new FeaturePage();
            featurePage.openFeaturePage();
            verifyFeatureHeader(featurePage);
            verifyFeatureDetails(featurePage);
        });
    }

    @Step("Verify Writing header")
    private void verifyFeatureHeader(FeaturePage featurePage) {
        Assert.assertTrue(featurePage.checkFeatureHeader(), "Feature page header is incorrect.");
    }

    @Step("Verify Writing details")
    private void verifyFeatureDetails(FeaturePage featurePage) {
        Assert.assertTrue(featurePage.checkFeatureDetail(), "Feature page details are incorrect.");
    }

    // Remove the try catch
    private void executeTest(Runnable testCode) {
        try {
            testCode.run();
        } catch (Exception e) {
            e.printStackTrace();
            Assert.fail("An exception occurred during the test: " + e.getMessage());
        } finally {
            BasePage.tearDownDriver();
        }
    }

    @Attachment(value = "Screenshot on failure", type = "image/png")
    public byte[] captureScreenshot() {
        return ((TakesScreenshot) BasePage.getDriver()).getScreenshotAs(OutputType.BYTES);
    }

    @AfterMethod
    public void tearDown(ITestResult result) {
        if (ITestResult.FAILURE == result.getStatus()) {
            captureScreenshot();
        }
        BasePage.tearDownDriver();
    }
}
