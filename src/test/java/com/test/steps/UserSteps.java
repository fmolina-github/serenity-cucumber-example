package com.test.steps;

import static io.restassured.RestAssured.*;

import io.restassured.response.Response;
import net.thucydides.core.annotations.Step;

public class UserSteps {

    private final String BASE_URI = "https://reqres.in/";

    @Step("#actor looks at the list of users")
    public Response looksAtTheListOfUsers() {
        Response response = null;

        response = given().baseUri(BASE_URI)
                .basePath("api/users")
                .queryParam("page", "1")
                .when().get();

        return response;
    }

    @Step("#actor requests the list of users for page")
    public Response requestsTheListOfUsersForPage(int page) {
        Response response = null;

        response = given().baseUri(BASE_URI)
                .basePath("api/users")
                .param("page", String.valueOf(page))
                .when().get();

        return response;
    }

    @Step("#actor requests to see the detail of user")
    public Response requestsToSeeTheDetailOfUser(int userId) {
        Response response = null;

        response = given().baseUri(BASE_URI)
                .basePath("api/users/{userId}")
                .pathParam("userId", userId)
                .when().get();

        return response;
    }

}
