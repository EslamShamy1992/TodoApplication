package com.qacart.todo.pages;

import com.qacart.todo.base.basePage;
import com.qacart.todo.config.EndPoint;
import com.qacart.todo.utils.ConfigUtils;
import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class TodoPage extends basePage {


    public TodoPage(WebDriver driver) {
        super(driver);
    }
    @FindBy(css="[data-testid=\"welcome\"]")
    private WebElement welcomemessage;
    @FindBy(css="[data-testid=\"add\"]")
    private WebElement addbutton ;
    @FindBy(css="[data-testid=\"todo-item\"]")
    private WebElement todoitem ;
    @FindBy(css="[data-testid=\"delete\"]")
    private WebElement deletebutton ;
    @FindBy(css="[data-testid=\"no-todos\"]")
    private WebElement notodomessage ;
    @Step
    public TodoPage load(){
        driver.get(ConfigUtils.getinstance().getbaseurl()+ EndPoint.TODO_PAGE_ENDPOINT);
        return this;
    }
    @Step
    public boolean iswelcomemessagedisplayed(){

       return welcomemessage.isDisplayed();
    }
    @Step
    public NewtodoPage clickonplusbutton(){

        addbutton.click();
        return new NewtodoPage(driver);
    }
    @Step
  public String gettodotext(){

       return todoitem.getText();
  }
    @Step
  public TodoPage clickondeletebutton(){

        deletebutton.click();
        return this;

  }
    @Step
  public String isnotodomessagedis(){

        return notodomessage.getText();
  }
}
