package com.company.lab2;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.concurrent.TimeUnit;

public class DuolingoEdgeTest {
    public WebDriver driver;
    public int random;

    public static int getRandomNumber(int min, int max) {
        return (int) ((Math.random() * (max - min)) + min);
    }

    @Before
    public void setUp(){
        System.setProperty("webdriver.edge.driver", "src/com/company/lab2/resources/msedgedriver.exe");

        driver = new EdgeDriver();

        driver = new FirefoxDriver();
        driver.manage().window().maximize();

        //Deleting all the cookies
        driver.manage().deleteAllCookies();

        //Specifiying pageLoadTimeout and Implicit wait
        driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

        //launching the specified URL
        driver.get("https://pl.duolingo.com/");
    }

    @After
    public void tearDown(){
        this.driver=null;
    }

    @Test
    public void startCourse(){
        driver.findElement(By.xpath("/html/body/div[1]/div/div/span[1]/div/div[1]/div[2]/div[1]/a")).click();
        driver.findElement(By.xpath("/html/body/div[1]/div/div/span/div/div/div/ul/a/div/div[2]/div")).click();
        driver.findElement(By.xpath("/html/body/div[1]/div/div/div/div[2]/div/div/div/label[1]/span")).click();
        driver.findElement(By.xpath("/html/body/div[1]/div/div/div/div[2]/div/div/button")).click();
        driver.findElement(By.xpath("/html/body/div[1]/div/div/div/div[2]/div/div/ul/label[5]")).click();
        driver.findElement(By.xpath("/html/body/div[1]/div/div/div/div[2]/div/div/button")).click();
        driver.findElement(By.xpath("/html/body/div[1]/div/div/div/div[2]/div/div/div/label[2]/span[1]")).click();
        driver.findElement(By.xpath("/html/body/div[1]/div/div/div/div[2]/div/div/button")).click();
        driver.findElement(By.xpath("/html/body/div[1]/div/div/div/div[2]/div/div/ul/li[3]/button")).click();
        driver.findElement(By.xpath("/html/body/div[1]/div/div/div/div[2]/div/div/div/button[1]")).click();
    }

    @Test
    public void getFaq(){
        driver.findElement(By.xpath("/html/body/div[1]/div/div/span[2]/div/div/div[2]/div/div[1]/ul/li[10]/a")).click();
        driver.findElement(By.xpath("/html/body/div[1]/div/div[2]/main/section/div[2]/section/div/span/p[1]/a")).click();
        WebElement searchbar = driver.findElement(By.xpath("//*[@id=\"query\"]"));
        searchbar.sendKeys("Czym jest Duolingo?");
        searchbar.sendKeys(Keys.RETURN);
        driver.findElement(By.xpath("/html/body/main/div[1]/section/ul/li[1]/a")).click();
        System.out.println(driver.findElement(By.xpath("/html/body/main/article/div[1]")).getText());
    }

    @Test
    public void startCertificateTest(){
        driver.findElement(By.xpath("/html/body/div[1]/div/div/div[2]/section[6]/div/div[1]/a")).click();
        driver.findElement(By.xpath("/html/body/div[2]/div/section[1]/div/div[1]/div[2]/button")).click();
        random = getRandomNumber(1000,10000);
        WebElement age = driver.findElement(By.xpath("/html/body/div[2]/div/div/section/form/div[1]/label/div/span[2]/input"));
        WebElement email = driver.findElement(By.xpath("/html/body/div[2]/div/div/section/form/div[3]/label/div/span[2]/input"));
        WebElement password = driver.findElement(By.xpath("/html/body/div[2]/div/div/section/form/div[5]/label/div/span[2]/input"));
        age.sendKeys("22");
        email.sendKeys("user"+random+"@gmail.com");
        password.sendKeys("password"+random+".");
        driver.findElement(By.xpath("/html/body/div[2]/div/div/footer/div/div[3]")).click();
        driver.findElement(By.xpath("/html/body/div[2]/div/div/section/form/ul/li[4]/label/div/span[2]")).click();
        driver.findElement(By.xpath("/html/body/div[2]/div/div/footer/div/div[3]")).click();
    }
}
