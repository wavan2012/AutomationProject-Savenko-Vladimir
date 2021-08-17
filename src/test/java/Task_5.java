import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Task_5 {
    /*
Написать 3 теста по сценарию ниже с различными данными и вариантами.
1.	Открыть сайт https://masterskayapola.ru/kalkulyator/laminata.html
2.	Ввести параметры для расчета.
3.	Нажать на кнопку ‘Рассчитать’.
4.	Проверить полученные значения.
5.	Закрыть окно браузера.
 */
    @Test
    public void test1() throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        Actions actions = new Actions(driver);
        driver.manage().window().maximize();

        driver.get("https://masterskayapola.ru/kalkulyator/laminata.html");
        driver.findElement(By.name("calc_roomwidth")).sendKeys(Keys.CONTROL + "a");
        driver.findElement(By.name("calc_roomwidth")).sendKeys("5" + Keys.TAB);//длина помещения
        driver.findElement(By.name("calc_roomheight")).sendKeys("8" + Keys.TAB);//ширина помещения
        driver.findElement(By.name("calc_lamwidth")).sendKeys("1270" + Keys.TAB);//длина ламината
        driver.findElement(By.name("calc_lamheight")).sendKeys("180" + Keys.TAB);//ширина ламината
        driver.findElement(By.name("calc_inpack")).sendKeys("15" + Keys.TAB);//ламината в упаковке
        driver.findElement(By.name("calc_price")).sendKeys("2000" + Keys.TAB);//цена ламината
        driver.findElement(By.xpath("//*[@id=\"inputcalc\"]/div/div[3]/div[2]/div/span[2]/select/option[2]")).click();
        actions.sendKeys(Keys.TAB);
        actions.moveToElement(driver.findElement(By.xpath("//*[@id=\"inputcalc\"]/div/div[4]/div[7]"))).perform();
        driver.findElement(By.name("calc_bias")).sendKeys("250" + Keys.TAB);//смещение рядов
        driver.findElement(By.name("calc_walldist")).sendKeys("5" + Keys.TAB);//отступ от стены
        actions.sendKeys(Keys.ENTER);//Нажатие клавиши рассчитать

        Thread.sleep(1000);
        Assert.assertEquals(driver.findElement(By.xpath("//*[@id=\"s_lam\"]/b")).getText(),"39.87");//площадь укладки
        Assert.assertEquals(driver.findElement(By.xpath("//*[@id=\"l_count\"]/b")).getText(),"180");//кол-во панелей
        Assert.assertEquals(driver.findElement(By.xpath("//*[@id=\"l_packs\"]/b")).getText(),"12");//кол-во упаковок
        Assert.assertEquals(driver.findElement(By.xpath("//*[@id=\"l_price\"]/b")).getText(),"82296");//стоимость
        Assert.assertEquals(driver.findElement(By.xpath("//*[@id=\"l_over\"]/b")).getText(),"0");//остатки
        Assert.assertEquals(driver.findElement(By.xpath("//*[@id=\"l_trash\"]/b")).getText(),"8");//отрезки
        driver.quit();
    }

    @Test
    public void test2() throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        Actions actions = new Actions(driver);
        driver.manage().window().maximize();

        driver.get("https://masterskayapola.ru/kalkulyator/laminata.html");
        driver.findElement(By.name("calc_roomwidth")).sendKeys(Keys.CONTROL + "a");
        driver.findElement(By.name("calc_roomwidth")).sendKeys("10" + Keys.TAB);//длина помещения
        driver.findElement(By.name("calc_roomheight")).sendKeys("10" + Keys.TAB);//ширина помещения
        driver.findElement(By.name("calc_lamwidth")).sendKeys("1000" + Keys.TAB);//длина ламината
        driver.findElement(By.name("calc_lamheight")).sendKeys("120" + Keys.TAB);//ширина ламината
        driver.findElement(By.name("calc_inpack")).sendKeys("100" + Keys.TAB);//ламината в упаковке
        driver.findElement(By.name("calc_price")).sendKeys("466" + Keys.TAB);//цена ламината
        driver.findElement(By.xpath("//*[@id=\"inputcalc\"]/div/div[3]/div[2]/div/span[2]/select/option[1]"))
                .click();//направление укладки
        actions.sendKeys(Keys.TAB);
        actions.moveToElement(driver.findElement(By.xpath("//*[@id=\"inputcalc\"]/div/div[4]/div[7]"))).perform();
        driver.findElement(By.name("calc_bias")).sendKeys("500" + Keys.TAB);//смещение рядов
        driver.findElement(By.name("calc_walldist")).sendKeys("1" + Keys.TAB);//отступ от стены
        actions.sendKeys(Keys.ENTER);//Нажатие клавиши рассчитать

        Thread.sleep(1000);
        Assert.assertEquals(driver.findElement(By.xpath("//*[@id=\"s_lam\"]/b")).getText(),"99.96");//площадь укладки
        Assert.assertEquals(driver.findElement(By.xpath("//*[@id=\"l_count\"]/b")).getText(),"840");//кол-во панелей
        Assert.assertEquals(driver.findElement(By.xpath("//*[@id=\"l_packs\"]/b")).getText(),"9");//кол-во упаковок
        Assert.assertEquals(driver.findElement(By.xpath("//*[@id=\"l_price\"]/b")).getText(),"50328");//стоимость
        Assert.assertEquals(driver.findElement(By.xpath("//*[@id=\"l_over\"]/b")).getText(),"60");//остатки
        Assert.assertEquals(driver.findElement(By.xpath("//*[@id=\"l_trash\"]/b")).getText(),"42");//отрезки
        driver.quit();
    }

    @Test
    public void test3() throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        Actions actions = new Actions(driver);
        driver.manage().window().maximize();

        driver.get("https://masterskayapola.ru/kalkulyator/laminata.html");
        driver.findElement(By.name("calc_roomwidth")).sendKeys(Keys.CONTROL + "a");
        driver.findElement(By.name("calc_roomwidth")).sendKeys("4" + Keys.TAB);//длина помещения
        driver.findElement(By.name("calc_roomheight")).sendKeys("6" + Keys.TAB);//ширина помещения
        driver.findElement(By.name("calc_lamwidth")).sendKeys("1222" + Keys.TAB);//длина ламината
        driver.findElement(By.name("calc_lamheight")).sendKeys("322" + Keys.TAB);//ширина ламината
        driver.findElement(By.name("calc_inpack")).sendKeys("33" + Keys.TAB);//ламината в упаковке
        driver.findElement(By.name("calc_price")).sendKeys("777" + Keys.TAB);//цена ламината
        driver.findElement(By.xpath("//*[@id=\"inputcalc\"]/div/div[3]/div[2]/div/span[2]/select/option[1]"))
                .click();//направление укладки
        actions.sendKeys(Keys.TAB);
        actions.moveToElement(driver.findElement(By.xpath("//*[@id=\"inputcalc\"]/div/div[4]/div[7]"))).perform();
        driver.findElement(By.name("calc_bias")).sendKeys("200" + Keys.TAB);//смещение рядов
        driver.findElement(By.name("calc_walldist")).sendKeys("8" + Keys.TAB);//отступ от стены
        actions.sendKeys(Keys.ENTER);//Нажатие клавиши рассчитать

        Thread.sleep(1000);
        Assert.assertEquals(driver.findElement(By.xpath("//*[@id=\"s_lam\"]/b")).getText(),"23.84");//площадь укладки
        Assert.assertEquals(driver.findElement(By.xpath("//*[@id=\"l_count\"]/b")).getText(),"64");//кол-во панелей
        Assert.assertEquals(driver.findElement(By.xpath("//*[@id=\"l_packs\"]/b")).getText(),"2");//кол-во упаковок
        Assert.assertEquals(driver.findElement(By.xpath("//*[@id=\"l_price\"]/b")).getText(),"20178");//стоимость
        Assert.assertEquals(driver.findElement(By.xpath("//*[@id=\"l_over\"]/b")).getText(),"2");//остатки
        Assert.assertEquals(driver.findElement(By.xpath("//*[@id=\"l_trash\"]/b")).getText(),"4");//отрезки
        driver.quit();
    }
}