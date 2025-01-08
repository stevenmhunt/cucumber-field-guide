import io.cucumber.java.en.Given;

public class FailStep {
    @Given("this step always fails")
    public void given_this_step_always_fails() {
        throw new Exception();
    }
}