package stepDefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.testng.Assert;
import pages.LoginPayload;
import resources.Utils;

import static io.restassured.RestAssured.*;

public class LoginStepDefinitions extends Utils {

    RequestSpecification res;

     public static String authorization;
     public static String userId;
    Response response;
    LoginPayload loginPayload = new LoginPayload();

    @Given("User Payload with email {string} and password {string}")
    public void user_payload_with_email_and_password(String userEmail, String userPassword)
    {
        res = given().log().all().spec(loginRequest())
                .body(loginPayload.setLoginPayload(userEmail,userPassword));

    }

    @When("User calls with Post and Login API http request")
    public void user_calls_with_post_and_login_api_http_request()
    {
        response = res.when().log().all().post("/api/ecom/auth/login");

        authorization = setJson(response,"token");
        userId = setJson(response,"userId");

    }

    @Then("The API call got success with status code {int}")
    public void the_api_call_got_success_with_status_code(Integer status)
    {
        Assert.assertEquals(response.getStatusCode(),status);

    }
}
