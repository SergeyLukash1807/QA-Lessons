package org.example;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ApiTests {

    // Base URL for the requests
    private static final String BASE_URL = "https://postman-echo.com";

    @Test
    public void getRequestTest() {
        Response response = RestAssured.get(BASE_URL + "/get");

        Assert.assertEquals(response.getStatusCode(), 200);
        System.out.println("GET Response: " + response.getBody().asString());
    }

    @Test
    public void postRawTextTest() {
        String requestBody =
                "{\n" +
                "    \"test\": \"value\"\n" +
                "}";

        Response response = RestAssured
                .given()
                .header("Content-type", "text/plain")
                .and()
                .body(requestBody)
                .when()
                .post(BASE_URL + "/post")
                .then()
                .extract().response();

        Assert.assertEquals(response.getStatusCode(), 200);
        System.out.println("POST Raw Text Response: " + response.getBody().asString());
    }

    @Test
    public void postFormDataTest() {
        Response response = RestAssured
                .given()
                .body("x-www-from-urlencoded")
                .multiPart("foo1", "bar1")
                .multiPart("foo2", "bar2")
                .when()
                .post(BASE_URL + "/post")
                .then()
                .extract().response();

        Assert.assertEquals(response.getStatusCode(), 200);
        System.out.println("POST Form Data Response: " + response.getBody().asString());
    }

    @Test
    public void putRequestTest() {
        String requestBody = "This is expected to be sent back as part of response body.";

        Response response = RestAssured
                .given()
                .header("Content-type", "application/json")
                .and()
                .body(requestBody)
                .when()
                .put(BASE_URL + "/put")
                .then()
                .extract().response();

        Assert.assertEquals(response.getStatusCode(), 200);
        System.out.println("PUT Response: " + response.getBody().asString());
    }

    @Test
    public void patchRequestTest() {
        String requestBody = "requestBody";

        Response response = RestAssured
                .given()
                .header("Content-Type", "multipart/form-data")
                .multiPart("file", "")
                .multiPart("", requestBody)
                .when()
                .patch(BASE_URL + "/patch")
                .then()
                .extract().response();

        Assert.assertEquals(response.getStatusCode(), 200);
        System.out.println("PATCH Response: " + response.getBody().asString());
    }

    @Test
    public void deleteRequestTest() {
        Response response = RestAssured.delete(BASE_URL + "/delete");

        Assert.assertEquals(response.getStatusCode(), 200);
        System.out.println("DELETE Response: " + response.getBody().asString());
    }
}