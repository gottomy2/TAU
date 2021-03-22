package com.company.lab2;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import java.util.concurrent.TimeUnit;

public class VintedChromeTest {
    public WebDriver driver;
    public int random;

    public static int getRandomNumber(int min, int max) {
        return (int) ((Math.random() * (max - min)) + min);
    }

    @Before
    public void setUp(){
        System.setProperty("webdriver.chrome.driver", "src/com/company/lab2/resources/chromedriver.exe");

        driver = new ChromeDriver();
        driver.manage().window().maximize();

        //Deleting all the cookies
        driver.manage().deleteAllCookies();

        //Specifiying pageLoadTimeout and Implicit wait
        driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

        //launching the specified URL
        driver.get("https://www.vinted.pl/");
        WebElement terms = driver.findElement(By.xpath("//*[@id=\"onetrust-accept-btn-handler\"]"));
        terms.click();
    }

    @After
    public void tearDown(){
        this.driver=null;
    }

    @Test
    public void registrationTest(){
        WebElement registerButton = driver.findElement(By.className("c-button__label"));
        registerButton.click();
        WebElement registerButton2 = driver.findElement(By.xpath("/html/body/div[8]/div/div/div/div/div/div/div/div[6]/div[5]/div[1]/a/span/span"));
        registerButton2.click();

        WebElement nameSurnameButton = driver.findElement(By.xpath("//*[@id=\"user_real_name\"]"));
        WebElement profileName = driver.findElement(By.xpath("//*[@id=\"user_login\"]"));
        WebElement email = driver.findElement(By.xpath("//*[@id=\"user_email\"]"));
        WebElement password = driver.findElement(By.xpath("//*[@id=\"user_password\"]"));
        WebElement confirmButton = driver.findElement(By.xpath("//*[@id=\"signup-form\"]/div[3]/div/div/button/span/span"));

        nameSurnameButton.sendKeys("Grzegorz Brzęczyszczykiewicz");
        random = getRandomNumber(1000,10000);
        String randomNickName = "user" + random;
        String randomEmail = "email" + random + "@gmail.com";
        String randomPassword = "password" + random + ".";

        profileName.sendKeys(randomNickName);
        email.sendKeys(randomEmail);
        password.sendKeys(randomPassword);
        confirmButton.click();

        WebElement confirmEmail = driver.findElement(By.xpath("//*[@id=\"content\"]/div/div/div/div/div/div[1]/div"));

        Assert.assertEquals("Prosimy o weryfikację informacji na twoim koncie",confirmEmail.getText());
    }


    @Test
    public void findWatch(){
        WebElement menTab = driver.findElement(By.xpath("/html/body/div[1]/div[2]/div[2]/div/div/ul/li[2]/span/a"));
        menTab.click();
        WebElement accessories = driver.findElement(By.xpath("/html/body/div[1]/div[2]/div[2]/div/div/ul/li[2]/div/div/div/div/div/div/div/div/div/div[1]/div[1]/div[4]/a"));
        accessories.click();
        WebElement watches = driver.findElement(By.xpath("/html/body/div[1]/div[2]/div[2]/div/div/ul/li[2]/div/div/div/div/div/div/div/div/div/div[1]/div[2]/div/div/div/div[4]/div[6]/div/a"));
        watches.click();

        WebElement prize = driver.findElement(By.xpath("/html/body/div[4]/div/section/div/div[2]/section/div/div/div[3]/div/div/div/div[4]/div/button/span/span[1]/span"));
        prize.click();

        WebElement from = driver.findElement(By.xpath("//*[@id=\"price_from\"]"));
        WebElement to = driver.findElement(By.xpath("//*[@id=\"price_to\"]"));

        from.sendKeys("0");
        to.sendKeys("300");

        WebElement watch1 = driver.findElement(By.className("ItemBox_overlay__1kNfX"));
        watch1.click();
    }

    @Test
    public void findNike(){
        WebElement searchBar = driver.findElement(By.className("c-input-bar__value"));
        searchBar.sendKeys("nike");
        WebElement suggestion = driver.findElement(By.xpath("/html/body/div[1]/div[1]/div/div/div[2]/div/div/form/div/div[2]/div/div/div/div/div/ul/li[1]/div/a"));
        suggestion.click();
        WebElement cat = driver.findElement(By.xpath("/html/body/div[4]/div/section/div/div[2]/section/div/div/div[3]/div/div/div/div[1]/div/button/span/span[1]/span"));
        cat.click();
        WebElement men = driver.findElement(By.xpath("/html/body/div[4]/div/section/div/div[2]/section/div/div/div[3]/div/div/div/div[1]/div/div/div/div/div/ul/li[2]/div/div[2]/div/span"));
        men.click();
        WebElement boots = driver.findElement(By.xpath("/html/body/div[4]/div/section/div/div[2]/section/div/div/div[3]/div/div/div/div[1]/div/div/div/div/div[3]/ul/li[3]/div/div[2]/div/span"));
        boots.click();
        WebElement all = driver.findElement(By.xpath("/html/body/div[4]/div/section/div/div[2]/section/div/div/div[3]/div/div/div/div[1]/div/div/div/div/div[3]/ul/li[1]/div/div[1]/div/span"));
        all.click();
    }
}
