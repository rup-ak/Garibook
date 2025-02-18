package org.garibook.com;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.testng.annotations.Test;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class BookTrip extends BaseClass{

    private final By logIn = By.xpath("//body/div[@id='__next']/nav[1]/div[1]/div[3]/div[2]/div[2]/div[2]/a[1]");
    private final By mobileNoField = By.xpath("//body/div[4]/div[1]/div[1]/div[2]/form[1]/div[1]/div[1]/input[1]");
    private final By otpMsg = By.xpath(String.format(PARTICULAR_TEXT_XPATH,"Your OTP is"));
    private final By sendBtn = By.xpath(String.format(PARTICULAR_TEXT_XPATH, "Send Code"));
    private final By carRental = By.id("uncontrolled-tab-example-tab-carRental");
//    private final By oneWay = By.xpath(String.format(PARTICULAR_TEXT_XPATH,"One Way"));
    private final By oneWay = By.xpath("//section[1]/div[1]/div[1]/div[2]/div[1]/div[2]/div[1]/div[1]/form[1]/div[1]/label[1]");
    private final By sedan = By.xpath("//section[1]/div[1]/div[1]/div[2]/div[1]/div[2]/div[1]/div[1]/form[1]/div[2]/div[1]/div[1]/label[1]/div[1]");


    private final By continueBtn = By.xpath("//section[1]/div[1]/div[1]/div[2]/div[1]/div[2]/div[1]/div[1]/form[1]/div[2]/div[1]/div[7]/div[1]/button[1]");
    private final By pickUp = By.xpath("//section[2]/div[1]/div[1]/div[1]/div[1]/div[2]/form[1]/div[3]/div[1]/input[1]");
    private final By dropOff= By.xpath("//section[2]/div[1]/div[1]/div[1]/div[1]/div[2]/form[1]/div[5]/div[1]/input[1]");
    private final By dateTime = By.xpath("//section[2]/div[1]/div[1]/div[1]/div[1]/div[2]/form[1]/div[6]/div[1]/div[1]/div[1]/input[1]");

//    private final By pickUpLoc = By.xpath(String.format(PARTICULAR_TEXT_XPATH,"Malibagh, Dhaka, Bangladesh"));
    private final By pickUpLoc = By.xpath("//section[2]/div[1]/div[1]/div[1]/div[1]/div[2]/form[1]/div[3]/ul[1]/li[1]");
 //    private final By dropOffLoc = By.xpath(String.format(PARTICULAR_TEXT_XPATH,"Uttara, Dhaka, Bangladesh"));
    private final By dropOffLoc = By.xpath("//section[2]/div[1]/div[1]/div[1]/div[1]/div[2]/form[1]/div[5]/ul[1]/li[1]");

    private final By date = By.xpath("//section[2]/div[1]/div[1]/div[1]/div[1]/div[2]/form[1]/div[6]/div[1]/div[2]/div[2]/div[1]/div[1]/div[1]/div[2]/div[5]/div[4]");
    private final By time = By.xpath("//section[2]/div[1]/div[1]/div[1]/div[1]/div[2]/form[1]/div[6]/div[1]/div[2]/div[2]/div[1]/div[1]/div[2]/div[2]/div[1]/ul[1]/li[47]");
    private final By promoCode = By.xpath("//section[2]/div[1]/div[1]/div[1]/div[1]/div[2]/form[1]/div[7]/div[1]/input[1]");
    private final By reqTrip = By.xpath("//section[2]/div[1]/div[1]/div[1]/div[1]/div[2]/form[1]/div[9]/button[1]");

    private final By name = By.xpath("//body/div[4]/div[1]/div[1]/form[1]/div[2]/div[1]/div[2]/input[1]");
    private final By contiBtn2 = By.xpath("//body/div[4]/div[1]/div[1]/form[1]/div[3]");



    @Test(priority = 1)
    public void login () throws InterruptedException {

        String mobileNo = "01711223131";
        JavascriptExecutor js = (JavascriptExecutor) driver;


        driver.findElement(logIn).click();


        driver.findElement(mobileNoField).sendKeys(mobileNo);

        driver.findElement(sendBtn).click();
        Thread.sleep(3000);

        String otpText = driver.findElement(otpMsg).getText();
        String otp = extractOTP(otpText);


        driver.findElement(By.id("otp1")).sendKeys(String.valueOf(otp.charAt(0)));
        driver.findElement(By.id("otp2")).sendKeys(String.valueOf(otp.charAt(1)));
        driver.findElement(By.id("otp3")).sendKeys(String.valueOf(otp.charAt(2)));
        driver.findElement(By.id("otp4")).sendKeys(String.valueOf(otp.charAt(3)));
        driver.findElement(By.xpath("//body/div[4]/div[1]/div[1]/div[2]/form[1]/div[2]/button[1]")).click();
        Thread.sleep(3000);
        driver.findElement(carRental).click();
        driver.findElement(oneWay).click();
        driver.findElement(By.xpath("//section[1]/div[1]/div[1]/div[2]/div[1]/div[2]/div[1]/div[1]/form[1]/div[2]/div[1]/div[2]/label[1]/div[1]"));

        driver.findElement(sedan).click();
        js.executeScript("window.scrollBy(0, 400)");
        driver.findElement(continueBtn).click();
        Thread.sleep(5000);
        driver.findElement(pickUp).sendKeys("Malibagh, Dhaka");
        driver.findElement(pickUpLoc).click();
        js.executeScript("window.scrollBy(0, 300)");
        driver.findElement(dropOff).sendKeys("Uttara");
        driver.findElement(dropOffLoc).click();
        driver.findElement(dateTime).click();
        driver.findElement(date).click();
        driver.findElement(time).click();
        js.executeScript("window.scrollBy(0, 300)");
        driver.findElement(promoCode).sendKeys("1122");
        driver.findElement(reqTrip).click();
        Thread.sleep(3000);
        driver.findElement(name).sendKeys("Rupak");
        js.executeScript("window.scrollBy(0, 300)");
        driver.findElement(contiBtn2).click();


    }

    public static String extractOTP(String text){
        Pattern pattern = Pattern.compile("\\d{4}");
        Matcher matcher = pattern.matcher(text);
        return matcher.find()? matcher.group():"OTP not found" ;
    }

}
