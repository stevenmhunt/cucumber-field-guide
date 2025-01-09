import io.cucumber.java.en.*;
import java.time.Duration;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.*;

public class MobileSteps {
    private final CustomWorld customWorld;

    public MobileSteps(CustomWorld customWorld) {
        this.customWorld = customWorld;
    }

    @Given("the app is opened")
    public void theAppIsOpened() {
        customWorld.getMyDemoApp();
    }

    @When("the {string} is clicked")
    public void theElementIsClicked(String item) {
        WebElement element = customWorld.getMyDemoApp().findElement(item);
        element.click();
    }

    @Then("the {string} should be displayed")
    public void theElementShouldBeDisplayed(String item) {
        WebElement element = customWorld.getMyDemoApp().findElement(item);
        new WebDriverWait(customWorld.getAppium(), Duration.ofSeconds(10))
            .until(ExpectedConditions.visibilityOf(element));
    }
}
