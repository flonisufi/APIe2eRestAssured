package pages;

import pojo.OrderDetails;
import pojo.OrdersPojo;

import java.util.ArrayList;
import java.util.List;

import static stepDefinitions.CreateProductStepDefinitions.productId;

public class OrderPage {

    OrderDetails orderDetails = new OrderDetails();
    OrdersPojo ordersPojo = new OrdersPojo();

    public OrdersPojo setOrderDetails()
    {
        orderDetails.setCountry("India");
        orderDetails.setProductOrderedId(productId);

        List<OrderDetails>orderDetailsList = new ArrayList<>();
        orderDetailsList.add(orderDetails);

        ordersPojo.setOrders(orderDetailsList);
        return ordersPojo;
    }
}
