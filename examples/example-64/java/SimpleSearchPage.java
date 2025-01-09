import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.*;

public class SimpleSearchPage {
    private WebDriver driver;
    private String url;
    private By searchBoxLocator = By.id("search_box");
    private By resultsLocator = By.id("results");

    public SimpleSearchPage(WebDriver driver, String baseUrl) {
        this.driver = driver;
        this.url = baseUrl + "/index.html";
    }

    public void open() { driver.navigate().to(url); }

    private WebElement findElement(By loc) {
        WebDriverWait wait = new WebDriverWait(driver, 10);
        return wait.until(ExpectedConditions.visibilityOfElementLocated(loc));
    }

    public void typeSearch(String query) {
        WebElement searchBox = findElement(searchBoxLocator);
        searchBox.clear();
        searchBox.sendKeys(query);
    }

    public void submitSearch() {
        findElement(searchBoxLocator).submit();
    }

    public String getResultsText() {
        return findElement(resultsLocator).getText();
    }
}