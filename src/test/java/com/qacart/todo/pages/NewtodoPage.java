package com.qacart.todo.pages;

import com.qacart.todo.base.basePage;
import com.qacart.todo.config.EndPoint;
import com.qacart.todo.utils.ConfigUtils;
import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class NewtodoPage extends basePage {

    public NewtodoPage(WebDriver driver) {
        super(driver);
    }


    @FindBy(css="[data-testid=\"new-todo\"]")
    private WebElement newtodoinput;
    @FindBy(css="[data-testid=\"submit-newTask\"]")
    private WebElement submitnewtodo;
    @Step
public NewtodoPage load(){
    driver.get(ConfigUtils.getinstance().getbaseurl()+ EndPoint.NEW_TODO_ENDPOINT);
    return this;
}
    @Step
    public TodoPage newtodoaction(String newtodo){
        newtodoinput.sendKeys(newtodo);
        submitnewtodo.click();
        return new TodoPage(driver);
    }
}
