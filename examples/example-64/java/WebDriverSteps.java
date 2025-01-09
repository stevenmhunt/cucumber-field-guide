import io.cucumber.java.en.*;
import static org.junit.jupiter.api.Assertions.*;

public class WebDriverSteps {
    private CustomWorld world;
    public WebDriverSteps(CustomWorld world) { this.world = world; }

    private SimpleSearchPage getSimpleSearchPage() {
        return new SimpleSearchPage(world.getDriver(), "http://localhost:9999");
    }

    @Given("the homepage is opened with webdriver")
    public void openHomepage() { getSimpleSearchPage().open(); }

    @When("{string} is typed into the search box with webdriver")
    public void theUserFillsInTheSearchBoxWith(String value) {
        getSimpleSearchPage().typeSearch(value);
    }

    @When("the {string} button is pressed with webdriver")
    public void theUserPresses(String btn) {
        getSimpleSearchPage().submitSearch();
    }

    @Then("the results should display {string} with webdriver")
    public void theUserShouldSeeInTheResults(String expectedText) {
        String results = getSimpleSearchPage().getResultsText();
        assertTrue(results.contains(expectedText));
    }
}