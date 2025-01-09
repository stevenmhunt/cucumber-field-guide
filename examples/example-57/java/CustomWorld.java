import java.time.Duration;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CustomWorld {
    private WebDriver driver;
    private WebDriverWait wait;
    // ...existing code...
    public WebDriver getDriver() { return getDriver(true); }
    public WebDriver getDriver(boolean isLazyLoad) {
        if (driver == null && isLazyLoad) {
            driver = new FirefoxDriver();
        }
        return driver;
    }

    public WebDriverWait getWait() {
        if (wait == null) {
            wait = new WebDriverWait(getDriver(), Duration.ofSeconds(10));
        }
        return wait;
    }
}