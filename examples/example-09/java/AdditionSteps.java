import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;
import org.junit.jupiter.api.Assertions; // for JUnit 4: import org.junit.Assert;

public class AdditionSteps {

    private int result;

    @When("The user adds {int} to {int}")
    public void theUserAdds(int num1, int num2) {
        result = num1 + num2;
    }

    @Then("the answer should be {int}")
    public void theAnswerShouldBe(int expected) {
        Assertions.assertEquals(expected, result); //for JUnit 4: Assert
    }
}