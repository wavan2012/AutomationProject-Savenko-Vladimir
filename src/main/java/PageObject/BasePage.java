package PageObject;

import driver.DriverCreation;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class BasePage {
    protected static By ttl = By.cssSelector("#header_container > div.header_secondary_container > span");
    WebDriver driver;

    public BasePage() {
        this.driver = DriverCreation.getDriver();
    }

    protected static void open(String url) {
        DriverCreation.getDriver().get(url);
    }

    public static void isDisplayed(By... elements) {
        for (By element : elements) {
            Assert.assertTrue(DriverCreation.getDriver().findElement(element).isDisplayed());
        }
    }

    public static void isDisplayed(By element, String text) {
        Assert.assertEquals(DriverCreation.getDriver().findElement(element).getText(), text);
    }

    public static boolean isDisplayed(String xpath) {
        boolean condition;
        try {
            condition = DriverCreation.getDriver().findElement(By.xpath(xpath)).isDisplayed();
        } catch (NoSuchElementException e) {
            return false;
        }
        return condition;
    }

    public static void click(By element) {
        DriverCreation.getDriver().findElement(element).click();
    }

    public static void click(String xpath) {
        DriverCreation.getDriver().findElement(By.xpath(xpath)).click();
    }

    public static void text(By element, String text) {
        DriverCreation.getDriver().findElement(element).sendKeys(text);
    }
}
