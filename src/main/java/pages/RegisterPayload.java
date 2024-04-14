package pages;

import com.github.javafaker.Faker;
import pojo.RegisterPojo;

public class RegisterPayload {

    RegisterPojo registerPojo = new RegisterPojo();

    Faker faker = new Faker();

    public RegisterPojo registerBody()
    {
        registerPojo.setConfirmPassword("Flonbaba1@");
        registerPojo.setFirstName(faker.name().firstName());
        registerPojo.setGender("Male");
        registerPojo.setLastName(faker.name().lastName());
        registerPojo.setOccupation("Student");
        registerPojo.setRequired(true);
        registerPojo.setUserEmail("flonPrindi1@gmail.com");
        registerPojo.setUserMobile("1234356732");
        registerPojo.setUserPassword("Flonbaba1@");
        registerPojo.setUserRole("customer");
        return registerPojo;
    }
}
