import io.cucumber.java.en.Given;
import org.junit.Assume;

public class SkipJUnit4Step {
    @Given("this given step is going to experience an error")
    public void given_this_step_is_going_to_experience_an_error() {
        Assume.assumeTrue(false);
    }
}