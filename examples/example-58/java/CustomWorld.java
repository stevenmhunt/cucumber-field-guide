import com.typesafe.config.*;
import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

public class CustomWorld {
    private Config config;
    private AppiumDriver appium;
    private MyDemoApp app;    
    public CustomWorld() {
        String env = System.getenv("TEST_ENV");
        this.config = ConfigFactory.load(env != null ? env : "default");
    } // ...existing code...

    public AppiumDriver getAppium() {
        if (appium == null) {
            Config capsConfig = config.getConfig("mobile.appium.caps");
            DesiredCapabilities c = new DesiredCapabilities();
            for (Map.Entry<String, ConfigValue> e : capsConfig.entrySet()) {
                String v = capsConfig.getString(e.getKey());
                if ("app".equals(e.getKey())) {
                    try {
                        c.setCapability(e.getKey(), new File(v).getCanonicalPath());
                    } catch (IOException ex) { c.setCapability(e.getKey(), v); }
                } else { c.setCapability(e.getKey(), v); }
            }
            try {
                appium = new AppiumDriver(
                    new URL(config.getString("mobile.appium.serverUrl")), c);
            } catch (Exception e) { throw new RuntimeException(e); }
        }
        return appium;
    }

    public MyDemoApp getMyDemoApp() {
        if (app == null) {
            app = new MyDemoApp(getAppium(), config.getConfig("mobile.mydemoapp"));
        }
        return app;
    } // ...existing code...
}
