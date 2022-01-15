package com.ex.ui;

import com.ex.BaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;


import java.util.Random;

public class SmokeUiSuite extends BaseTest {
    @Test
    public void firstTest() {
        webDriver.get("http://automationpractice.com/");
        By signIn = By.xpath("//a[@class='login']");
        webDriver.findElement(signIn).click();

        //TODO generate random email, and check register form is displayed
        webDriver.findElement(By.xpath("//input[@id='email_create']")).sendKeys(randomGenerator()+"@gmail.com");
        webDriver.findElement(By.xpath("//button[@id='SubmitCreate']")).click();
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        Assert.assertEquals(webDriver.getCurrentUrl(),
                "http://automationpractice.com/index.php?controller=authentication&back=my-account#account-creation");
        WebElement expectedStartOfForm = webDriver.findElement(By.xpath("//h1[contains(text(),'Create an account')]"));
        WebElement displayedStartOfForm = webDriver.findElement(By.xpath("//h1[contains(text(),'Create an account')]"));
        Assert.assertEquals(displayedStartOfForm,expectedStartOfForm);

    }

    public static String randomGenerator(){
    String alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz";
    StringBuilder sb = new StringBuilder();
    Random random = new Random();
    int length = 7;
    for (int i = 0; i < length; i++){
        int index = random.nextInt(alphabet.length());
        char randomChar = alphabet.charAt(index);
        sb.append(randomChar);
    }
    String randomString = sb.toString();
        return randomString;
}

    @Test
    public void firstTest1() {
        webDriver.get("http://automationpractice.com/");
        By signIn = By.xpath("//a[@class='login']");
        webDriver.findElement(signIn).click();

        //TODO verify that error 'email already exist' is displayed
        webDriver.findElement(By.xpath("//input[@id='email_create']")).sendKeys("example@email.com");
        webDriver.findElement(By.xpath("//button[@id='SubmitCreate']")).click();

        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        WebElement displayedMassage = webDriver.findElement(By.xpath("//li[contains(text(),'An account using this email address has already been registered.')]"));
        WebElement expectedMassage = webDriver.findElement(By.xpath("//li[contains(text(),'An account using this email address has already been registered.')]"));

        Assert.assertEquals(displayedMassage, expectedMassage);

        System.out.println("Massage - 'An account using this email address has already been registered. " +
                "Please enter a valid password or request a new one.' - is displayed.");


    }
}
