package pages;

import pojo.LoginPojo;

public class LoginPayload {

    LoginPojo loginPojo = new LoginPojo();

    public LoginPojo setLoginPayload(String userEmail, String userPassword)
    {
        loginPojo.setUserEmail(userEmail);
        loginPojo.setUserPassword(userPassword);
        return loginPojo;
    }
}
