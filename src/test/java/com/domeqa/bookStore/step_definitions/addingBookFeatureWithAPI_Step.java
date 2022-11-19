package com.domeqa.bookStore.step_definitions;


import com.domeqa.bookStore.utilities.APIUtilities;
import com.google.gson.Gson;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.Assert;

import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.*;

public class addingBookFeatureWithAPI_Step {
    String token, userId, user, pass;

    @Given("User create an account with using {string} and {string}")
    public void user_create_an_account_with_using_and(String userName, String password) {
            user = userName;
            pass = password;
        Map<String ,Object> requestMap= new HashMap<>();
        requestMap.put("userName",userName);
        requestMap.put("password",password);

        System.out.println(requestMap);

        Response response= given().accept(ContentType.JSON)
                .and()
                .contentType(ContentType.JSON).body(requestMap)
                .when().post( "https://demoqa.com/Account/v1/User");

        userId = response.path("userID");

        System.out.println("userId: "+userId);

    }

    @Given("User generate a token with using {string} and {string}")
    public void user_generate_a_token_with_using_and(String userName , String password) {

        token = APIUtilities.generateToken(userName,password);


    }
    @Given("User get authorized with using {string} and {string}")
    public void user_get_authorized_with_using_and(String userName, String password) {


        Map<String ,Object> requestMap= new HashMap<>();
        requestMap.put("userName",userName);
        requestMap.put("password",password);

       // System.out.println(requestMap);

        Response response= given().accept(ContentType.JSON)
                .and()
                .contentType(ContentType.JSON).body(requestMap)
                .when().post( "https://demoqa.com/Account/v1/Authorized");

        Assert.assertTrue(response.body().asString().contains("true"));
        //response.prettyPrint();

    }

    @When("User add book which {string} number book to the collection")
    public void user_add_book_which_number_book_to_the_collection(String isbn) {

        String url = "https://demoqa.com/BookStore/v1/Books";
        String body=  "{\n" +
                "  \"userId\": \"" + userId + "\",\n" +
                "  \"collectionOfIsbns\": [\n" +
                "    {\n" +
                "      \"isbn\": \"" + isbn  + "\"\n" +
                "    }\n" +
                "  ]\n" +
                "}";
        Map jsonBody = new Gson().fromJson(body, Map.class);

        //System.out.println(jsonBody.toString());

        Response response = given().auth().basic(user, pass)
                .accept(ContentType.JSON)
                .body(jsonBody)
                .when()
                .post(url);

        //response.then().log().all();
        System.out.println(response.statusCode());
        System.out.println(response.getBody());
        System.out.println(response.body().asString());
    }


    @Then("User confirm that book is added to collection and delete all books from the collection")
    public void user_confirm_that_book_is_added_to_collection_and_delete_all_books_from_the_collection() {

        //String url = ("https://demoqa.com/BookStore/v1/Books/{UserId}";
        //Response response = given().auth().basic(user, pass)
              //  .accept(ContentType.JSON)
               // .body(userId)
               // .when()
                //.post(url);

        //Response response2=given().accept(ContentType.JSON)
                //.and().pathParam("UserId",userId)
                //.when().get("url");

        //Assert.assertEquals(204,response2.statusCode());
       // Assert.assertEquals(response.path("userId"), userId);
//ATTENTION: This Code Which is below this line must be use  otherwise test will not work for second attempt
//(IT WILL REMOVE THE USER FOR THE SECOND AND THIRD OR OTHER ATTEMPTS TEST CAN BE RUN).

        Response response = given().auth().basic(user, pass)
                .accept(ContentType.JSON)
                .when()
                .delete("https://demoqa.com/Account/v1/User/" + userId);

        Assert.assertEquals(response.statusCode(),204);

    }



}
