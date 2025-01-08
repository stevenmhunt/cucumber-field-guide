import io.cucumber.java.en.Then;
import dev.failsafe.*;
import java.time.Duration;
import java.time.temporal.ChronoUnit;

public class RetryStep {
    @Then("some long-running assertion is performed")
    public void then_some_long_running_assertion_is_performed() {
        RetryPolicy<Object> retryPolicy = RetryPolicy.builder()
            .withMaxRetries(10)
            .withDelay(Duration.ofSeconds(1))
            .withBackoff(100, 2000, ChronoUnit.MILLIS)
            .build();

        Failsafe.with(retryPolicy).run(() -> {
            // code which may require retries.
        });
    }
}