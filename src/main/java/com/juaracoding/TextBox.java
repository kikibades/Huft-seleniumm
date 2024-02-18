package com.juaracoding;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class TextBox {
    public static void main(String[] args) {

        String path = "C:\\mytools\\chromedriver.exe";
        System.setProperty("webdriver.chrome.driver",path);
        WebDriver driver = new ChromeDriver();
        JavascriptExecutor js = (JavascriptExecutor) driver;
        String url = "https://demoqa.com/text-box";
        driver.get(url);
        System.out.println("Open web demoqa textbox");
        driver.findElement(By.id("userName")).sendKeys("Kikibades");
        driver.findElement(By.id("userEmail")).sendKeys("kikibadess@gmail.com");
        driver.findElement(By.id("currentAddress")).sendKeys("Depok");
        driver.findElement(By.id("permanentAddress")).sendKeys("Depok");
        js.executeScript("window.scrollBy(0,2000");
        driver.findElement(By.id("submit")).click();

        //driver.quit();
    }
}
