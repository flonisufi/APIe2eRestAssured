package pages;

import java.io.File;
import java.util.HashMap;
import java.util.Map;

import static stepDefinitions.LoginStepDefinitions.userId;

public class CreateProductPage {

    public Map<String,Object> createProdParams()
    {
        Map<String,Object>info = new HashMap<>();
        info.put("productName","Laptop");
        info.put("productAddedBy",userId);
        info.put("productCategory","fashion");
        info.put("productSubCategory","shirts");
        info.put("productPrice","11500");
        info.put("productDescription","Lenova");
        info.put("productFor","woman");
        return info;
    }
}
