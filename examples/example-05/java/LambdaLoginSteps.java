import io.cucumber.java8.En;
import com.product.app.Session;

public class LambdaLoginSteps implements En {
    public MySteps() {
        Given("the user logs in", (String user) -> Session.performLogin());
    }
}