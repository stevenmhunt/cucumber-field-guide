import io.cucumber.java.en.*;
import net.serenitybdd.screenplay.actions.*;
import net.serenitybdd.screenplay.questions.Text;
import org.openqa.selenium.By;

import static org.junit.jupiter.api.Assertions.*;

public class ScreenplaySteps {
    private CustomWorld world;
    
    public ScreenplaySteps(CustomWorld world) {
        this.world = world;
    }

    @Given("the homepage is opened with screenplay")
    public void theUserIsOnTheHomepage() {
        world.getActor().attemptsTo(
            Open.url("http://host.docker.internal:9999"));
    }

    @When("{string} is typed into the search box with screenplay")
    public void theUserFillsInTheSearchBoxWith(String value) {
        world.getActor().attemptsTo(
            Enter.theValue(value).into(By.id("search_box")));
    }

    @When("the {string} button is pressed with screenplay")
    public void theUserPresses(String btn) {
        world.getActor().attemptsTo(
            Click.on(By.cssSelector("input[type='submit'][value='" + btn + "']")));
    }

    @Then("the results should display {string} with screenplay")
    public void theUserShouldSeeInTheResults(String expectedText) {
        String text = world.getActor().asksFor(Text.of(By.id("results")));
        assertTrue(text.contains(expectedText));
    }
}