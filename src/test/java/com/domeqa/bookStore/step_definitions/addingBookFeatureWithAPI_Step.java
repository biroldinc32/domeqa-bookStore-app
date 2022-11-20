package com.domeqa.bookStore.step_definitions;


import com.domeqa.bookStore.utilities.APIUtilities;
import com.domeqa.bookStore.utilities.ConfigurationReader;
import com.google.gson.Gson;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.Assert;

import java.util.*;

import static io.restassured.RestAssured.*;

public class addingBookFeatureWithAPI_Step {
    String token, userId, user, pass;

    @Given("User create an account with using {string} and {string}")
    public void user_create_an_account_with_using_and(String userName, String password) {
        user = userName;
        pass = password;
        Map<String, Object> requestMap = new HashMap<>();
        requestMap.put("userName", userName);
        requestMap.put("password", password);

        System.out.println(requestMap);

        Response response = given().accept(ContentType.JSON)
                .and()
                .contentType(ContentType.JSON).body(requestMap)
                .when().post("https://demoqa.com/Account/v1/User");

        userId = response.path("userID");

        System.out.println("userId: " + userId);

    }

    @Given("User generate a token with using {string} and {string}")
    public void user_generate_a_token_with_using_and(String userName, String password) {

        token = APIUtilities.generateToken(userName, password);


    }

    @Given("User get authorized with using {string} and {string}")
    public void user_get_authorized_with_using_and(String userName, String password) {


        Map<String, Object> requestMap = new HashMap<>();
        requestMap.put("userName", userName);
        requestMap.put("password", password);

        // System.out.println(requestMap);

        Response response = given().accept(ContentType.JSON)
                .and()
                .contentType(ContentType.JSON).body(requestMap)
                .when().post("https://demoqa.com/Account/v1/Authorized");

        Assert.assertTrue(response.body().asString().contains("true"));
        //response.prettyPrint();

    }


}