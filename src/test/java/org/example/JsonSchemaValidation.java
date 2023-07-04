package org.example;

import io.restassured.response.Response;
import io.restassured.response.ResponseBody;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.given;
import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchemaInClasspath;

public class JsonSchemaValidation {




    @Test

    public void testGet()
    {
        baseURI = "https://reqres.in/api";

        Response    response =given().get("/users?page=2")
                .then().assertThat().body(matchesJsonSchemaInClasspath("schema.json")).statusCode(200).extract().response();

        ResponseBody responseBody= response.getBody();

        System.out.println(responseBody.asString());


    }
}
