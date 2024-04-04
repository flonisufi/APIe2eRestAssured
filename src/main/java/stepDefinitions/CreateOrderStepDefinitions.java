package stepDefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.testng.Assert;
import pages.OrderPage;
import resources.Utils;

import static io.restassured.RestAssured.*;

public class CreateOrderStepDefinitions extends Utils {

    RequestSpecification res;
    Response response;
    OrderPage orderPage = new OrderPage();


    @Given("User Payload for an order")
    public void user_payload_for_an_order()
    {
        res = given().spec(createOrder())
                .body(orderPage.setOrderDetails());

    }

    @When("User calls with Post and Create Order http request")
    public void user_calls_with_post_and_create_order_http_request()
    {
        response = res.when().post("/api/ecom/order/create-order");
        String resp = response.asString();
        System.out.println(resp);

    }

    @Then("The API Order call got success with status code {int}")
    public void the_api_order_call_got_success_with_status_code(Integer status)
    {
        Assert.assertEquals(response.getStatusCode(),status);

    }
}
