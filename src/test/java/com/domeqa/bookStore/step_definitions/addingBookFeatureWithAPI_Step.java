package com.domeqa.bookStore.step_definitions;


import com.domeqa.bookStore.utilities.APIUtilities;
import com.domeqa.bookStore.utilities.ConfigurationReader;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.given;

public class addingBookFeatureWithAPI_Step {
    String token, userId;

    @Given("User create an account with using {string} and {string}")
    public void user_create_an_account_with_using_and(String string, String string2) {

        Map<String ,Object> requestMap= new HashMap<>();
        requestMap.put("userName","JohnDoe");
        requestMap.put("password",  "*John_980#");

        System.out.println(requestMap);

        Response response= given().accept(ContentType.JSON)
                .and()
                .contentType(ContentType.JSON).body(requestMap)
                .when().post( "https://demoqa.com/Account/v1/User");

        userId = response.path("userID");

        System.out.println("userId"+userId);

    }

    @Given("User generate a token with using {string} and {string}")
    public void user_generate_a_token_with_using_and(String username , String password) {

        token = APIUtilities.generateToken("JohnDoe","*John_980#");


    }
    @Given("User get authorized with using {string} and {string}")
    public void user_get_authorized_with_using_and(String string, String string2) {





    }
    @Given("User get user id number")
    public void user_get_user_id_number() {




    }
    @When("User add book which {string} number book to the collection")
    public void user_add_book_which_number_book_to_the_collection(String string) {




    }
    @Then("User confirm that book is added to collection and delete all books from the collection")
    public void user_confirm_that_book_is_added_to_collection_and_delete_all_books_from_the_collection() {




    }

}



