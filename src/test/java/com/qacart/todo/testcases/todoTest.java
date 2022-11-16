package com.qacart.todo.testcases;

import com.qacart.todo.API.RegisterApi;
import com.qacart.todo.API.TasksApi;
import com.qacart.todo.base.baseTest;
import com.qacart.todo.pages.NewtodoPage;
import com.qacart.todo.pages.TodoPage;
import com.qacart.todo.pages.loginPage;
import com.qacart.todo.utils.ConfigUtils;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import org.testng.Assert;
import org.testng.annotations.Test;
@Feature("Todo feature")
public class todoTest extends baseTest {
    @Story("Add Todo")
    @Test(description = "should be able to add a new todo correctly ")
    public void shouldbeabletoaddnewTodo(){
       RegisterApi rigesterApi= new RegisterApi();
        rigesterApi.register();
        NewtodoPage newtodopage= new NewtodoPage(getDriver());
        newtodopage.load();
        injectcookiesToBrowser( rigesterApi.getcookies());
        String actualresult=  newtodopage
                        .load()
                         .newtodoaction("eslam")
                        .gettodotext();
        Assert.assertEquals(actualresult,"eslam");

    }
    @Story("Delete Todo")
    @Test(description="should be able to delete todo correctly ")
    public void shouldbeabletodeletetodo(){

        RegisterApi rigesterApi= new RegisterApi();
        rigesterApi.register();
        TasksApi taskApi= new TasksApi();

        taskApi.addTask(rigesterApi.gettoken());
       TodoPage todopage= new TodoPage(getDriver());
        todopage.load();
        injectcookiesToBrowser( rigesterApi.getcookies());
        boolean notodo= todopage
                .load()
                .clickondeletebutton()
                .iswelcomemessagedisplayed();

       Assert.assertTrue(notodo);


    }
}
