package PageObject;

import org.testng.Assert;

public class CartPage extends BasePage {


    public static void openPage() {
        open("https://www.saucedemo.com/cart.html");
    }

    public static void verifyProduct(String product) {
        Assert.assertTrue(isDisplayed("//*[@id=\"remove-sauce-" + product + "\"]"));
    }
    public static void verifyNonExistProduct(String product) {
        Assert.assertFalse(isDisplayed("//*[@id=\"remove-sauce-" + product + "\"]"));
    }
    public static void verifyCartPage() {
        isDisplayed(ttl, "YOUR CART");
    }

    public static void removeFromCart(String product) {
        click("//*[@id=\"remove-sauce-" + product + "\"]");
    }
}
