package rest_assured.exercises._02_post;



public class Exe02_LoginRequestParameters {
    public static final String URL = "http://putsreq.com/YYcndHzIR0Q5Kxk6FCOR";

    //////////////// Valid Login Parameters
    public static final String USER_NAME_PARAMETER_NANE = "username";
    public static final String USER_NAME_PARAMETER_VALUE = "admin";

    public static final String PASSWORD_PARAMETER_NAME = "password";
    public static final String PASSWORD_PARAMETER_VALUE = "123456";

    public static final String SECRET_KEY_HEADER_NANE = "SECRET-KEY";
    public static final String SECRET_KEY_HEADER_VALUE = "Ken-Sent-Me";

    public static final String VALID_LOGIN_BODY_TEXT = "Login OK";

    public static final String SESSION_ID_HEADER_NAME = "SESSION-ID";


    public static final int VALID_LOGIN_STATUS_CODE = 200;

    //////////////// Secret Key Missing Parameters
    public static final String SECRET_KEY_MISSING_BODY_TEXT = "Key is missing";
    public static final int MISSING_SECRET_KEY_STATUS_CODE = 400;

    //////////////// Invalid Credentials Parameters
    public static final String INVALID_USER_NAME_PARAMETER_VALUE = "admin111";
    public static final String INVALID_PASSWORD_PARAMETER_VALUE = "1234563";

    public static final int INVALID_CREDENTIALS_STATUS_CODE = 401;

    public static final String INVALID_CREDENTIALS_BODY_TEXT = "Login Failed";
}
