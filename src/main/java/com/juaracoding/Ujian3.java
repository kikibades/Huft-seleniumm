package com.juaracoding;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.net.DatagramSocket;

public class Ujian3 {
    public static void main(String[] args) {

        String path = "C:\\mytools\\chromedriver.exe";
        System.setProperty("webdriver.chrome.driver",path);
        WebDriver driver = new ChromeDriver();
        JavascriptExecutor js = (JavascriptExecutor) driver;
        driver.manage().window().maximize();
        String url = "https://www.saucedemo.com/";
        driver.get(url);
        System.out.println("Open saucedemo");
        driver.findElement(By.id("user-name")).sendKeys("standard_user");
        driver.findElement(By.id("password")).sendKeys("secret_sauce");
        driver.findElement(By.id("login-button")).click();

        //validasi assert expecetd & actual
        String expectedUrl = "https://www.saucedemo.com/inventory.html";
        String currentUrl = driver.getCurrentUrl();
        System.out.println(currentUrl);
        if(expectedUrl.equals(currentUrl)){
            System.out.println("Passed");
        } else {
            System.out.println("Failed");
        }
        String expectedTxt = "Swag Labs";
        String appLogo = driver.findElement(By.xpath("//div[@class='app_logo']")).getText();
        Utils.assertEqualsCustom(appLogo, expectedTxt);


        //add to cart
        //driver.findElement(By.xpath("//*[@id=\"add-to-cart-sauce-labs-backpack\"]")).click();
        driver.findElement(By.xpath("//*[@id=\"add-to-cart-sauce-labs-bike-light\"]")).click();
        driver.findElement(By.xpath("//*[@id=\"shopping_cart_container\"]/a")).click();
        String expected2 = "https://www.saucedemo.com/cart.html";
        String actual2 = driver.getCurrentUrl();
        Utils.assertEqualsCustom(actual2, expected2);
        //another validation
        String expected3 = "Your Cart";
        String actual3 = driver.findElement(By.xpath("//*[@id=\"header_container\"]/div[2]/span")).getText();
        Utils.assertEqualsCustom(actual3, expected3);

        //validasi ada product di cart
        //String nol = "0";
        //String getvalue = driver.findElement(By.xpath("//*[@id=\"shopping_cart_container\"]/a/span")).getText();
        //if(getvalue.equals(nol)) {
         //   System.out.println("Failed");
       // } else {
        //    System.out.println("Passed");
       // }

        WebDriver.Navigation navigate = driver.navigate();
        navigate.back();
        String actualNew = driver.findElement(By.xpath("//*[@id=\"remove-sauce-labs-bike-light\"]")).getText();
        String expectedNew = "Remove";
        if (actualNew.equals(expectedNew)){
            System.out.println("Passed");
        } else {
            System.out.println("Failed");
        }






        //driver.findElement(By.xpath("//*[@id=\"checkout\"]")).click();








        Utils.delay(3);
        driver.quit();
}
}
