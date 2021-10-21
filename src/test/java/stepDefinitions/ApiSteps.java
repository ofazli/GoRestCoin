package stepDefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.restassured.RestAssured;
import pages.ApiValidation;

public class ApiSteps extends ApiValidation {
    @Given("user given api url {string}")
    public void userGivenApiUrl(String url) {
        RestAssured.baseURI = url;
        System.out.println("user given api url " + url);
    }

    @Given("set api endpoint {string}")
    public void setApiEndpoint(String endpoint) {
        RestAssured.basePath = endpoint;
//        RestAssured.port = 8080;
        System.out.println("set api endpoint " + endpoint);
    }

    @And("User creates new user with request body {string},{string},{string},{string}")
    public void userCreatesNewUserWithRequestBody(String name, String gender, String email, String status) {
        response = postMethod(name,gender,email,status);
    }


    @Then("validate the status code {int}")
    public void validateTheStatusCode(int statusCode) {
        System.out.println("validate the status code " + statusCode);
    }

    @And("validate the userId is not null")
    public void validateTheUserIdIsNotNull() {
        System.out.println("validate the userId is not null");
    }

    @And("validate the user Name is {string}")
    public void validateTheUserNameIs(String name) {
        System.out.println("validate the user Name is " + name);
    }

    @And("validate the user Gender is {string}")
    public void validateTheUserGenderIs(String gender) {
        System.out.println("validate the user Gender is " + gender);
    }

    @And("validate the user Email is {string}")
    public void validateTheUserEmailIs(String email) {
        System.out.println("validate the user Email is " + email);
    }

    @And("validate the user Status is {string}")
    public void validateTheUserStatusIs(String status) {
        System.out.println("validate the user Status is " + status);
    }
}
