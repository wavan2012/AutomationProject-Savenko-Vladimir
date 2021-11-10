package PageObject;

import org.openqa.selenium.By;

public class LoginPage extends BasePage {
    private static final By login = By.id("user-name");
    private static final By lgnPsw = By.id("password");
    private static final By lgnBtn = By.id("login-button");
    private static final By errMsg = By.xpath("//*[@id=\"login_button_container\"]/div/form/div[3]/h3");


    public static void openPage() {
        open("https://www.saucedemo.com/");
    }

    public static void verifyLoginPage() {
        isDisplayed(login, lgnPsw, lgnBtn);
    }


    public static void verifyCartPage() {
        isDisplayed(ttl, "YOUR CART");
    }

    public static void verifyStartError() {
        isDisplayed(errMsg);
    }

    public static void verifyStartError(String text) {
        isDisplayed(errMsg, text);
    }

    public static void startStandUser() {
        text(login, "standard_user");
        text(lgnPsw, "secret_sauce");
        click(lgnBtn);
    }

    public static void startLockUser() {
        text(login, "locked_out_user");
        text(lgnPsw, "secret_sauce");
        click(lgnBtn);
    }

    public static void startProblemUser() {
        text(login, "problem_user");
        text(lgnPsw, "secret_sauce");
        click(lgnBtn);
    }
}
