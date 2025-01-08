import io.cucumber.java.en.Given;

public class PendingStep {
    @Given("this step is not ready to use")
    public void given_some_step_is_not_ready_to_use() {
        throw new io.cucumber.java.PendingException();
    }
}