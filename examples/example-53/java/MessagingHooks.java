import com.rabbitmq.client.Channel;
import io.cucumber.java.*;

public class MessagingHooks {
    private final CustomWorld world;
    private static MessagingService service;

    public MessagingHooks(CustomWorld world) {
        this.world = world;
    }
    
    public static MessagingService getMessaging() {
        return service;
    }

    @BeforeAll
    public static void beforeAll() throws Exception {
        service = new MessagingService();
        service.start();
    }

    @AfterAll
    public static void afterAll() throws Exception {
        service.stop();
    }

    @After
    public void afterScenario() throws Exception {
        Channel channel = this.world.getChannel(false);
        if (channel != null && channel.getConnection().isOpen()) {
            channel.getConnection().close();
        }
    }
}
