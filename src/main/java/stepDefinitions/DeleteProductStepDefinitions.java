package stepDefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.testng.Assert;
import resources.Utils;

import static io.restassured.RestAssured.given;
import static stepDefinitions.CreateProductStepDefinitions.productId;

public class DeleteProductStepDefinitions extends Utils {

    RequestSpecification res;
    Response response;
    String message;

    @Given("User Delete a product")
    public void user_delete_a_product()
    {
        res = given().spec(deleteProd())
                .pathParam("productId",productId);

    }

    @When("User call with Delete with http request")
    public void user_call_with_delete_with_http_request()
    {
        response = res.when().delete("/api/ecom/product/delete-product/{productId}");
        message = setJson(response,"message");

    }

    @Then("The API Delete call got success with message")
    public void the_api_delete_call_got_success_with_message()
    {
        Assert.assertEquals(message,"Product Deleted Successfully");

    }
}
