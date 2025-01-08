import io.cucumber.java.en.Given;
import org.junit.jupiter.api.Assumptions;

public class SkipJUnit5Step {
    @Given("this given step is going to experience an error")
    public void given_this_step_is_going_to_experience_an_error() {
        Assumptions.assumeTrue(false);
    }
}