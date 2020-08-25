package com.test.definitions;

import com.test.steps.UserSteps;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.response.Response;
import net.thucydides.core.annotations.Steps;

import static org.hamcrest.Matchers.*;

public class UsersStepDefinitions {

    @Steps
    private UserSteps userSteps;

    private Response response;

    @Given("Fer looks at a list of users")
    public void userLooksAtAListOfUsers() {
        response = userSteps.looksAtTheListOfUsers();
//        System.out.println(response.getBody().print());
        response.then()
                .statusCode(200)
                .body("page", equalTo(1));
    }

    @When("he request the list of users for page {int}")
    public void userRequestTheListOfUsersForPage(int page) {
        response = userSteps.requestsTheListOfUsersForPage(page);
//        System.out.println(response.getBody().print());
        response.then()
                .statusCode(200)
                .body("page", equalTo(page));
    }

    @When("he request to see the detail of user {int}")
    public void userRequestToSeeTheDetailOfUser(int userId) {
        response = userSteps.requestsToSeeTheDetailOfUser(userId);
//        System.out.println(response.getBody().print());
        response.then()
                .statusCode(200)
                .body("data", notNullValue());
    }

    @When("he request to see the detail of an invalid user")
    public void userRequestToSeeTheDetailOfAnInvalidUser() {
        response = userSteps.requestsToSeeTheDetailOfUser(0);
//        System.out.println(response.getBody().print());
        response.then()
                .statusCode(404);
    }

    @Then("a success response with a list of available users is retrieved")
    public void aSuccessResponseWithAListOfAvailableUsersIsRetrieved() {
//        System.out.println(response.getBody().print());
        response.then()
                .statusCode(200)
                .body("data", notNullValue());
    }

    @Then("a success response with user detail is retrieved")
    public void aSuccessResponseWithUserDetailIsRetrieved() {
        response.then()
                .statusCode(200)
                .body("data.id", equalTo(2));
    }

    @Then("a not found response with empty user detail is retrieved")
    public void aNotFountResponseWithEmptyUserDetailIsRetrieved() {
        response.then()
                .statusCode(404)
                .body("isEmpty()", is(true));
    }
}
