package com.qacart.todo.pages;

import com.qacart.todo.base.basePage;
import com.qacart.todo.utils.ConfigUtils;
import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class loginPage extends basePage {


    public loginPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(css="[data-testid=\"email\"]")
     private WebElement emailinput;
    @FindBy(css="[data-testid=\"password\"]")
    private WebElement passwordinput;
    @FindBy(css="[data-testid=\"submit\"]")
    private WebElement submit;
@Step
    public loginPage load(){
        driver.get(ConfigUtils.getinstance().getbaseurl());
        return this;
    }


@Step
    public TodoPage logaction(String email,String password){

        emailinput.sendKeys(email);
        passwordinput.sendKeys(password);
        submit.click();
        return new TodoPage(driver);
    }

}
