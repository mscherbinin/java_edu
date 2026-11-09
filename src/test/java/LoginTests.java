import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;

public class LoginTests extends BaseTest {

    @Test
    void emptyFieldsTest() {
        open("/login");
        $("[data-testid=login-input]").pressEnter();
        $("[data-testid=error-message]").shouldBe(text("Login and password are required (minimum 3 and 6 characters)"));
    }

    @Test
    void emptyLoginTest() {
        open("/login");
        $("[data-testid=password-input]").setValue("12345").pressEnter();
        $("[data-testid=error-message]").shouldBe(text("Login is required (minimum 3 characters)"));
    }
}
