package resources;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

import static stepDefinitions.LoginStepDefinitions.authorization;

public class Utils {

    public RequestSpecification loginRequest()
    {
        RequestSpecification res = new RequestSpecBuilder()
                .setBaseUri(ConfigurationReader.getProperty("baseUrl"))
                .setContentType(ContentType.JSON)
                .build();
        return res;
    }

    public RequestSpecification createProduct()
    {
        RequestSpecification res = new RequestSpecBuilder()
                .setBaseUri(ConfigurationReader.getProperty("baseUrl"))
                .addHeader("authorization",authorization)
                .build();
        return res;
    }

    public RequestSpecification createOrder()
    {
        RequestSpecification res = new RequestSpecBuilder()
                .setBaseUri(ConfigurationReader.getProperty("baseUrl"))
                .addHeader("authorization",authorization)
                .setContentType(ContentType.JSON)
                .build();
        return res;
    }

    public RequestSpecification deleteProd()
    {
        RequestSpecification res = new RequestSpecBuilder()
                .setBaseUri(ConfigurationReader.getProperty("baseUrl"))
                .addHeader("authorization",authorization)
                .setContentType(ContentType.JSON)
                .build();
        return res;
    }


    public String setJson(Response response,String key)
    {
        String resp = response.asString();
        JsonPath jsonPath = new JsonPath(resp);
        return jsonPath.get(key).toString();
    }
}
