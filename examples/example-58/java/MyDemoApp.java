import com.typesafe.config.Config;
import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.*;

public class MyDemoApp {
    private final AppiumDriver appium;
    private final Config config;

    public MyDemoApp(AppiumDriver appium, Config config) {
        this.appium = appium;
        this.config = config;
    }

    public WebElement findElement(String name) {
        String xpath = config.getString(name);
        return new WebDriverWait(appium, Duration.ofSeconds(10))
                .until(ExpectedConditions.presenceOfElementLocated(By.xpath(xpath)));
    }
}
