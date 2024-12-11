package main.test;

import base.BasePage;
import base.readENV;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;
import page.loginPage;

public class loginGrammarly {

    @BeforeSuite
    private void LoadEnv() {
        readENV.loadProperties("STG");
    }
    @Test
    public static void executeLoginTest() {
        BasePage.initializeDriver();
        try {
            loginPage lP = new loginPage();

            lP.login();

            System.out.println("Login executed successfully!");

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            BasePage.tearDownDriver();
        }
    }
}
