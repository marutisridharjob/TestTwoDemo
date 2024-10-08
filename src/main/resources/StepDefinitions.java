package com.example.test;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.junit.jupiter.api.Assertions;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

public class StepDefinitions {

    private Response response;

    @Given("I send a GET request to {string}")
    public void iSendAGETRequestTo(String endpoint) {
        response = given().get(endpoint);
    }

    @Then("the response status code should be {int}")
    public void theResponseStatusCodeShouldBe(int statusCode) {
        response.then().statusCode(statusCode);
    }

    @Then("the response body should contain a list of students")
    public void theResponseBodyShouldContainAListOfStudents() {
        response.then().body("size()", greaterThan(0));
    }

    @Given("I send a POST request to {string} with body:")
    public void iSendAPOSTRequestToWithBody(String endpoint, String body) {
        response = given()
            .contentType("application/json")
            .body(body)
            .post(endpoint);
    }

    @Then("the response body should contain:")
    public void theResponseBodyShouldContain(String expectedBody) {
        response.then().body("", containsString(expectedBody));
    }

    @Given("I send a DELETE request to {string}")
    public void iSendADELETERequestTo(String endpoint) {
        response = given().delete(endpoint);
    }
}