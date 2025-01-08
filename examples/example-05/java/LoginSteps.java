import io.cucumber.java.en.Given;
import com.product.app.Session;

public class LoginSteps {
    @Given("the user logs in")
    public void the_user_logs_in(String user) {
        Session.performLogin();
    }
}