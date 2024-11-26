package main.test;

import base.BasePage;
import org.testng.annotations.Test;
import page.loginPage;

public class loginGrammarly {
    @Test
    public static void main(String[] args) {
        BasePage.initializeDriver();

        try {
            loginPage lP = new loginPage();

            lP.openLoginPage();

            lP.login("binhminh9631@gmail.com", "Binhminh294.");

            System.out.println("Login executed successfully!");

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            BasePage.tearDownDriver();
        }
    }
}
