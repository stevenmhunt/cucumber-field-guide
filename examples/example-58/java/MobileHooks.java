import io.cucumber.java.*;

public class MobileHooks {
    private CustomWorld world;

    public MobileHooks(CustomWorld world) {
        this.world = world;
    }

    @Before("@mobile")
    public void beforeMobile() {
        world.getMyDemoApp();
    }

    @After("@mobile")
    public void afterMobile() {
        world.getAppium().quit();
    }
}
