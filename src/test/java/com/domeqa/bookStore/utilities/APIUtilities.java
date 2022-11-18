package com.domeqa.bookStore.utilities;

import io.restassured.http.ContentType;
import io.restassured.response.Response;

import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.given;

public class APIUtilities {


    public static String generateToken(String userName, String password){

        Map<String ,Object> requestMap= new HashMap<>();
        requestMap.put("userName",userName);
        requestMap.put("password",password);


        Response response= given().accept(ContentType.JSON)
                .and()
                .contentType(ContentType.JSON).body(requestMap).
                when().post( "https://demoqa.com/Account/v1/GenerateToken");

        String token = response.path("token");
        String status = response.path("status");


        return token;
    }



}
