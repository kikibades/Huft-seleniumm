package com.juaracoding;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class SelectMenu {
    public static void main(String[] args) {

        String path = "C:\\mytools\\chromedriver.exe";
        System.setProperty("webdriver.chrome.driver",path);
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        String Baseurl = "https://demoqa.com/";
        String menuName = "select-menu";
        String url = Baseurl+menuName;
        driver.get(url);
        String menuNameReplace = menuName.replace("-"," ");
        System.out.println("Open web demoqa"+menuNameReplace);

        WebElement selectColor = By.xpath("//*[@id='oldSelectMenu']").findElement(driver);
        Select select = new Select(selectColor);
        select.selectByIndex(4);
        select.selectByValue("5");
        select.selectByVisibleText("Indigo");

        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
       // driver.quit();

    }
}
