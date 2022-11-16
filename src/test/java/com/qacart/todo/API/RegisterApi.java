package com.qacart.todo.API;

import com.qacart.todo.config.EndPoint;
import com.qacart.todo.objects.User;
import com.qacart.todo.utils.UserUtils;
import io.restassured.http.Cookie;
import io.restassured.http.Cookies;
import io.restassured.response.Response;

import java.util.List;

import static io.restassured.RestAssured.given;

public class RegisterApi {
    private static List<Cookie> restassuredcookies;
    private static  String accesstoken;
    private static String userid;
    private static  String firstname;

  public String gettoken(){
      return this.accesstoken;
  }
    public List<Cookie> getcookies(){
        return this.restassuredcookies;
    }
    public String getuserid() {
        return this.userid;
    }
        public String getfirstname() {
            return this.firstname;
        }
    public void register(){
        User user= UserUtils.generaterandomuser();
        Response response=
                given()
                   .baseUri("https://qacart-todo.herokuapp.com")
                        .header("Content-Type","application/json")
                        .body(user)
                        .log().all()
                        .when()
                             .post(EndPoint.API_REGISTER_ENDPOINT)
                .then()
                        .log().all()
                        .extract().response();
        if(response.statusCode() !=201){
            throw  new RuntimeException("something went wrong");
        }
         restassuredcookies=response.detailedCookies().asList();
        accesstoken=response.path("access_token");
        userid=response.path("userID");
         firstname=response.path("firstName");

    }
}
