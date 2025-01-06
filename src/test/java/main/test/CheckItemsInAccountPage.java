package main.test;

import base.BasePage;
import base.readENV;
import org.testng.Assert;
import page.accountPage;
import page.profilePage;
import page.subscriptionPage;
import page.writingPage;
import page.featurePage;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

public class checkItemsInAccountPage {

    @BeforeSuite
    private void loginToPage() {
        readENV.loadProperties("STG");
        loginGrammarly.executeLoginTest();
        accountPage ap = new accountPage();
        ap.action();
    }

    @Test
    public static void checkProfilePage() {
        try {
            profilePage pP = new profilePage();
            Assert.assertTrue(pP.checkProfileHeader());
            Assert.assertTrue(pP.checkAccountName());
            Assert.assertTrue(pP.checkAccountEmail());
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            BasePage.tearDownDriver();
        }
    }

    @Test
    public static void checkSubscriptionPage() {
        try {
            subscriptionPage sP = new subscriptionPage();
            sP.openSubPage();
            Assert.assertTrue(sP.checkSubscriptionHeader());
            Assert.assertTrue(sP.checkSubscriptionDetail());
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            BasePage.tearDownDriver();
        }
    }

    @Test
    public static void checkWritingPage() {
        try {
            writingPage wP = new writingPage();
            wP.openWritingPage();
            Assert.assertTrue(wP.checkWritingHeader());
            Assert.assertTrue(wP.checkWritingDetail());
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            BasePage.tearDownDriver();
        }
    }

    @Test
    public static void checkFeaturePage() {
        try {
            featurePage setP = new featurePage();
            setP.openFeaturePage();
            Assert.assertTrue(setP.checkFeatureHeader());
            Assert.assertTrue(setP.checkFeatureDetail());
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            BasePage.tearDownDriver();
        }
    }
}
