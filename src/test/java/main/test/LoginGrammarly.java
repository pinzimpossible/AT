package main.test;

import base.BasePage;
import base.ReadEnv;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;
import page.LoginPage;

public class LoginGrammarly {

    //Run before Test
    @BeforeSuite
    private void LoadEnv() {
        ReadEnv.loadProperties("STG");
    }
    @Test
    public static void executeLoginTest() {
        BasePage.initializeDriver();
        try {
            LoginPage loginpage = new LoginPage();

            loginpage.login();

            System.out.println("Login executed successfully!");

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            BasePage.tearDownDriver();
        }
    }
}
