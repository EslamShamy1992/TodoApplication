package com.qacart.todo.testcases;

import com.qacart.todo.base.baseTest;
import com.qacart.todo.pages.loginPage;
import com.qacart.todo.utils.ConfigUtils;
import io.qameta.allure.Description;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import org.testng.Assert;
import org.testng.annotations.Test;
@Feature("Auth Feature")
public class loginTest extends baseTest {

    @Story("login with email and password")
    @Description("it will login by filling the email and the password and navigate to the todo page")
    @Test(description = "Test the login functionality using email and password")
    public void shouldbeabletologinwithemailandpassword(){
        loginPage Loginpage= new loginPage(getDriver());
        boolean welcome =
                Loginpage
                        .load()
                        .logaction(ConfigUtils.getinstance().getemail(), ConfigUtils.getinstance().getpassword())
                         .iswelcomemessagedisplayed();
        Assert.assertTrue(welcome);

    }

}
