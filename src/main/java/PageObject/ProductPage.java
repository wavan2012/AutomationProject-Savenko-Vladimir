package PageObject;

import org.openqa.selenium.By;

public class ProductPage extends BasePage {
    private static final By doggy = By.cssSelector("#item_0_img_link > img[src$='sl-404.168b1cce.jpg']");

    public static void openPage() {
        open("https://www.saucedemo.com/inventory.html");
    }

    public static void verifyProductPage() {
        isDisplayed(ttl, "PRODUCTS");
    }

    public static void verifyProblemProductPage() {
        verifyProductPage();
        isDisplayed(doggy);
    }
    public static void toCart() {
        click("//*[@id=\"shopping_cart_container\"]");
    }

    public static void addToCart(String product) {
        click("//*[@id=\"add-to-cart-sauce-" + product + "\"]");
    }

    public static void removeFromCart(String product) {
        click("//*[@id=\"remove-sauce-" + product + "\"]");
    }
}

