package com.qacart.todo.factory;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;

import java.time.Duration;

public class Driverfactory {


   public WebDriver initializedriver(){
       String browser= System.getProperty("browser","CHROME");
       WebDriver driver;
       switch(browser){
           case"CHROME":
               WebDriverManager.chromedriver().setup();
                driver= new ChromeDriver();
               break;
           case "FIREFOX":
               WebDriverManager.firefoxdriver().setup();
                driver= new FirefoxDriver();
               break;
           case"SAFARI":
                driver= new SafariDriver();
                break;
           default:
               throw new RuntimeException("the browser is not supported");
       }
       driver.manage().window().maximize();
      driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(9));
       return driver;
   }

}
