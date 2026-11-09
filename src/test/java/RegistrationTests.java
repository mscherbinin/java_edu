import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;

public class RegistrationTests extends BaseTest {

    @Test
    void emptyFieldsTest() {
        open("/register");
        $("[data-testid=register-login-input]").pressEnter();
        $("[data-testid=register-error-message]").shouldHave(text("Login and password are required (minimum 3 and 6 characters)"));

    }

    @Test
    void passwordNotMatch() {
        open("/register");
        $("[data-testid=register-login-input]").setValue("qwe");
        $("[data-testid=register-password-input]").setValue("12345");
        $("[data-testid=confirm-password-input]").setValue("1234567").pressEnter();
        $("[data-testid=register-error-message]").shouldHave(text("Passwords do not match"));
    }
}
