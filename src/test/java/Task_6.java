import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;

public class Task_6 {
    private  static WebDriver chrome;

    @Test
    public void test1() throws InterruptedException {
       initial("https://saucedemo.com/");
       findel("id","user-name" ).sendKeys("standard_user");
       findel("nm","password").sendKeys("secret_sauce");
        findel("cn","submit-button").click();
        findel("cs","button#add-to-cart-sauce-labs-backpack").click();
        findel("cs","button.btn.btn_primary.btn_small.btn_inventory").click();
        findel("cs","div[class]>a[class]:first-child").click();
        Assert.assertEquals(findel("xp","//*[@id=\"item_4_title_link\"]/div").getText(),"Sauce Labs Backpack");
        Assert.assertEquals(findel("xp","//*[@class=\"inventory_item_price\"]").getText(),"$29.99");
        Thread.sleep(1000);

    }

    static void initial(String i){
        chrome = new ChromeDriver();
        chrome.manage().window().maximize();
        chrome.get(i);
    }
    WebElement findel(String srcEx, String src){
        if (srcEx == "nm") return chrome.findElement(By.name(src));
        else if (srcEx == "id") return chrome.findElement(By.id(src));
        else if (srcEx == "xp") return chrome.findElement(By.xpath(src));
        else if (srcEx == "cn") return chrome.findElement(By.className(src));
        else if (srcEx == "cs") return chrome.findElement(By.cssSelector(src));
        else if (srcEx == "tn") return chrome.findElement(By.tagName(src));
        else if (srcEx == "lt") return chrome.findElement(By.linkText(src));
        else if (srcEx == "pt") return chrome.findElement(By.partialLinkText(src));
        else return null;
    }

    @AfterTest
    public void postconditions() {
        chrome.quit();
    }
}
