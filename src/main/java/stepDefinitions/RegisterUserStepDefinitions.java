package stepDefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.testng.Assert;
import pages.RegisterPayload;
import resources.Utils;

import static io.restassured.RestAssured.*;

public class RegisterUserStepDefinitions extends Utils {

    RequestSpecification req;
    Response response;
    RegisterPayload registerPayload = new RegisterPayload();

    @Given("User Payload personal Informations")
    public void user_payload_personal_informations()
    {
        req = given().log().all().spec(loginRequest())
                .body(registerPayload.registerBody());

    }

    @When("User calls Signup with Post http request")
    public void user_calls_signup_with_post_http_request()
    {
        response = req.when().log().all().post("/api/ecom/auth/register");

    }

    @Then("The API Signup call for success with status code {int}")
    public void the_api_signup_call_for_success_with_status_code(Integer status)
    {
        Assert.assertEquals(response.getStatusCode(),status);


    }

    @Then("Validate the message response")
    public void validate_the_message_response()
    {
        String confirmMessage = setJson(response,"message");
        Assert.assertEquals(confirmMessage,"Registered Successfully");

    }
}
