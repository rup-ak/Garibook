package org.garibook.com;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class BaseClass {

    protected WebDriver driver;
    protected String URL = "http://fe.garibook.com/";
    protected static final String PARTICULAR_TEXT_XPATH =  "//*[contains(text(),'%s')]";

    @BeforeMethod
    public void setup (){
        driver = new ChromeDriver();
        driver.get(URL);
        driver.manage().window().maximize();
    }

    @AfterMethod
    public void tearDown(){
        driver.quit();
    }

}
