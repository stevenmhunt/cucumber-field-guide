import io.cucumber.java.en.Then;
import java.util.concurrent.*;
import org.awaitility.Awaitility.*;

public class TimeoutStep {
    @Then("some long-running assertion is performed")
    public void then_some_long_running_assertion_is_performed() {
        await().atMost(60, TimeUnit.SECONDS).until(() -> { /* <your code> */ });
    }
}