import io.cucumber.java.en.*;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import static org.junit.jupiter.api.Assertions.*;

public class WebDriverSteps {
    private CustomWorld world;
    public WebDriverSteps(CustomWorld world) { this.world = world; }

    @Given("the homepage is opened with webdriver")
    public void openHomepage() { world.getDriver().get("http://localhost:9999"); }

    @When("{string} is typed into the search box with webdriver")
    public void theUserFillsInTheSearchBoxWith(String value) {
        WebElement searchBox = world.getDriver().findElement(By.id("search_box"));
        searchBox.sendKeys(value);
    }

    @When("the {string} button is pressed with webdriver")
    public void theUserPresses(String btn) {
        WebElement submitButton = world.getDriver().findElement(
            By.cssSelector("input[type='submit'][value='" + btn + "']"));
        submitButton.click();
    }

    @Then("the results should display {string} with webdriver")
    public void theUserShouldSeeInTheResults(String expectedText) {
        WebElement results = world.getWait().until(
            ExpectedConditions.visibilityOfElementLocated(By.id("results")));
        assertTrue(results.getText().contains(expectedText));
    }
}