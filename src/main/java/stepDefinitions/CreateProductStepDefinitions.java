package stepDefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.testng.Assert;
import pages.CreateProductPage;
import resources.Utils;

import java.io.File;
import java.util.Map;

import static io.restassured.RestAssured.*;

public class CreateProductStepDefinitions extends Utils {

    RequestSpecification res;
    Response response;
    public static String productId;
    CreateProductPage createProductPage = new CreateProductPage();
    Map<String,Object>productParams = createProductPage.createProdParams();

    @Given("User give params for a Product")
    public void user_give_params_for_a_product()
    {
        res = given().spec(createProduct())
                .params(productParams)
                .multiPart("productImage",new File("C:\\Users\\Fujitsu\\Downloads\\dress.png.jpg"));

    }

    @When("User calls with Post and Create API http request")
    public void user_calls_with_post_and_create_api_http_request()
    {
        response = res.when().post("/api/ecom/product/add-product");
        productId = setJson(response,"productId");

    }

    @Then("The API Create call got success with status code {int}")
    public void the_api_create_call_got_success_with_status_code(Integer status)
    {
        Assert.assertEquals(response.getStatusCode(),status);

    }

}
