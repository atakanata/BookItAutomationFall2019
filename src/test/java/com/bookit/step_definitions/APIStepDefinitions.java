package com.bookit.step_definitions;

import com.bookit.utilities.APIUtilities;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.junit.Assert;

import java.util.List;

import static io.restassured.RestAssured.*;

public class APIStepDefinitions {
    private RequestSpecification requestSpecification;
    private Response response;
    private String token;
    private JsonPath jsonPath;
    private ContentType contentType;



    @Given("authorization token is provided for {string}")
    public void authorization_token_is_provided_for(String role) {
        token = APIUtilities.getToken(role);
    }

    @Given("user accepts content type as {string}")
    public void user_accepts_content_type_as(String string) {
        if (string.toLowerCase().contains("json")){
            contentType = ContentType.JSON;
        }else if (string.toLowerCase().contains("xml")){
            contentType = ContentType.XML;
        }else if (string.toLowerCase().contains("html")){
            contentType = ContentType.HTML;
        }
    }

    @When("user sends GET request to {string}")
    public void user_sends_GET_request_to(String path) {
        response = given().accept(contentType).auth().oauth2(token).when().get(path).prettyPeek();
    }

    @Then("user should be able to see {int} rooms")
    public void user_should_be_able_to_see_rooms(int expectedNumberOfRooms) {
        List<Object> rooms = response.jsonPath().get();
        Assert.assertEquals(expectedNumberOfRooms,rooms.size());
    }


    @Then("user should be able to see all room names")
    public void user_should_be_able_to_see_all_room_names() {

    }

    @Then("user verifies that response status code is 200​")
    public void user_verifies_that_response_status_code_is_200​() {

    }

    @When("user verifies that response status code is {int}")
    public void user_verifies_that_response_status_code_is(Integer int1) {

    }

    @Then("user payload contains following room names:")
    public void user_payload_contains_following_room_names(io.cucumber.datatable.DataTable dataTable) {
        // Write code here that turns the phrase above into concrete actions
        // For automatic transformation, change DataTable to one of
        // E, List<E>, List<List<E>>, List<Map<K,V>>, Map<K,V> or
        // Map<K, List<V>>. E,K,V must be a String, Integer, Float,
        // Double, Byte, Short, Long, BigInteger or BigDecimal.
        //
        // For other transformations you can register a DataTableType.
        throw new io.cucumber.java.PendingException();
    }
}
