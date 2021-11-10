import PageObject.CartPage;
import PageObject.LoginPage;
import PageObject.ProductPage;
import driver.DriverCreation;
import org.testng.annotations.Test;

public class Task_9 {
    /*
 1.	Для приложения https://www.saucedemo.com описать все страницы, используя Page Object Pattern
 2.	Написать минимум 6 тестов для приложения
        a.	3 теста на логин со всеми пользователями
        b.	1 тест на добавление товара в корзину
        c.	1 тест на удаление товара из корзины
        d.	1 тест на оплату

     */
    @Test(priority = 1)
    public void test1() {
        LoginPage.openPage();
        LoginPage.verifyLoginPage();
        LoginPage.startStandUser();
        ProductPage.verifyProductPage();
        DriverCreation.quitDriver();
    }

    @Test(priority = 2)
    public void test2() {
        LoginPage.openPage();
        LoginPage.verifyLoginPage();
        LoginPage.startLockUser();
        LoginPage.verifyStartError("Epic sadface: Sorry, this user has been locked out.");
        DriverCreation.quitDriver();
    }

    @Test(priority = 3)
    public void test3() {
        LoginPage.openPage();
        LoginPage.verifyLoginPage();
        LoginPage.startProblemUser();
        ProductPage.verifyProblemProductPage();
        DriverCreation.quitDriver();
    }

    @Test(priority = 4)
    public void test4() {
        LoginPage.openPage();
        LoginPage.verifyLoginPage();
        LoginPage.startStandUser();
        ProductPage.verifyProductPage();
        ProductPage.addToCart("labs-bolt-t-shirt");
        ProductPage.toCart();
        CartPage.verifyProduct("labs-bolt-t-shirt");
        CartPage.removeFromCart("labs-bolt-t-shirt");
        DriverCreation.quitDriver();
    }

    @Test(priority = 5)
    public void test5() {
        LoginPage.openPage();
        LoginPage.verifyLoginPage();
        LoginPage.startStandUser();
        ProductPage.verifyProductPage();
        ProductPage.addToCart("labs-bolt-t-shirt");
        ProductPage.toCart();
        CartPage.verifyProduct("labs-bolt-t-shirt");
        CartPage.removeFromCart("labs-bolt-t-shirt");
        CartPage.verifyNonExistProduct("labs-bolt-t-shirt");
        DriverCreation.quitDriver();
    }
}
