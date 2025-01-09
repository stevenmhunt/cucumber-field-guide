import io.cucumber.java.After;

public class WebDriverHooks {
    private CustomWorld world;
    public WebDriverHooks(CustomWorld world) { this.world = world; }
    @After
    public void tearDown() {
        if (world.getDriver(false) != null) { world.getDriver().quit(); }
    }
}