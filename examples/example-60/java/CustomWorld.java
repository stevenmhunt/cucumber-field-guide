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
            try {
                FirefoxOptions options = new FirefoxOptions();
                Url url = new URL("http://localhost:4444/wd/hub");
                driver = new RemoteWebDriver(url, options);
            } catch (MalformedURLException e) { throw new RuntimeException(e); }
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