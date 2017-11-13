package selenium._08_code_modeling;

import org.openqa.selenium.By;

public class Elements {

    public static final By USERNAME_INPUT = By.name("username");
    public static final By PASSWORD_INPUT = By.name("password");
    public static final By LOGIN_BUTTON = By.className("loginbtn");
    public static final By VALID_LOGIN_VERIFICATION_TEXT = By.xpath("//*[contains(text(),'Hi, Johny Smith')]");
    public static final By INVALID_LOGIN_VERIFICATION_TEXT = By.xpath("//*[contains(text(),'Invalid Email or Password')]");

}
