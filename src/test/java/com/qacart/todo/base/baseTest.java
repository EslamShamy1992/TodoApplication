package com.qacart.todo.base;

import com.qacart.todo.factory.Driverfactory;
import com.qacart.todo.utils.CookieUtils;
import io.qameta.allure.Allure;
import io.qameta.allure.Step;
import io.restassured.http.Cookie;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class baseTest {

    protected ThreadLocal<WebDriver> driver= new ThreadLocal<>();

    public void setDriver(WebDriver driver){
        this.driver.set(driver);

    }
    public WebDriver getDriver(){
       return this.driver.get();

    }
    @BeforeMethod
    public void setup(){
        WebDriver driver= new Driverfactory().initializedriver();
        setDriver(driver);

    }
    @AfterMethod
    public void teardown(ITestResult result) {
        String testcasename =result.getMethod().getMethodName();
        File destfile= new File("target"+File.separator+"screenshots"+ File.separator+testcasename+".png");
        takeScreenshots(destfile);

        getDriver().quit();
    }
    @Step
    public void injectcookiesToBrowser(List<Cookie> restAssuredCookies){
      List<org.openqa.selenium.Cookie> seleniumCookies= CookieUtils.convertRestAssuredCookiesToSeleniumCookies(restAssuredCookies);
      for(org.openqa.selenium.Cookie cookie:seleniumCookies){
          getDriver().manage().addCookie(cookie);
      }
    }
public void takeScreenshots(File destfile){
    File file= ((TakesScreenshot)getDriver()).getScreenshotAs(OutputType.FILE);
    try {
        FileUtils.copyFile(file,destfile);
        InputStream is = new FileInputStream((destfile));
        Allure.addAttachment("screenshots",is);
    } catch (IOException e) {
        throw new RuntimeException(e);
    }
}

}
