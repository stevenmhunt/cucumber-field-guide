import io.cucumber.java.en.Given;
import com.product.app.Session;

public class LoginStep {
    @Given("the user {string} logs in")
    public void the_user_string_logs_in(String user) {
        Session.performLogin(user);
    }
}