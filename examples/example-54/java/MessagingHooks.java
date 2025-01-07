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

    private DeliverCallback onTopicMessage() {
        return (consumerTag, delivery) -> {
            String message = new String(delivery.getBody(), "UTF-8");
            String topic = delivery.getEnvelope().getRoutingKey();
            world.addTopicMessage(topic, message);
            System.out.println(String.format("---- Topic %s: %s", topic, message));
        };
    }

    @Before("@rabbitmq")
    public void beforeScenario() throws Exception {
        Channel channel = this.world.getChannel();
        channel.exchangeDeclare("topic_exchange", BuiltinExchangeType.TOPIC);
        String q = channel.queueDeclare().getQueue();
        channel.queueBind(q, "topic_exchange", "#");
        channel.basicConsume(q, true, onTopicMessage(), consumerTag -> { });
    }

    @After
    public void afterScenario() throws Exception {
        Channel channel = this.world.getChannel(false);
        if (channel != null && channel.getConnection().isOpen()) {
            channel.getConnection().close();
        }
    }
}
