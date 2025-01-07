import com.rabbitmq.client.Channel;
import dev.failsafe.*;
import io.cucumber.java.en.*;
import java.time.Duration;
import java.time.temporal.ChronoUnit;
import static org.junit.jupiter.api.Assertions.*;

public class MessagingSteps {
    private final CustomWorld world;

    public MessagingSteps(CustomWorld world) {
        this.world = world;
    }

    @When("a message {string} is sent to the queue {string}")
    public void a_message_is_sent_to_queue(String message, String queueName)
        throws Exception {
        Channel channel = world.getChannel();
        channel.basicPublish("", queueName, null, message.getBytes());
    }

    @Then("the last message received is {string}")
    public void the_last_message_received_is(String message) throws Exception {
        RetryPolicy<Object> retryPolicy = RetryPolicy.builder()
                .withMaxRetries(10)
                .withDelay(Duration.ofSeconds(1))
                .withBackoff(100, 2000, ChronoUnit.MILLIS)
                .build();
        Failsafe.with(retryPolicy).run(() -> {
            String actual = MessagingHooks.getMessaging().getLastMessage();
            assertEquals(message, actual);
        });
    }

    @When("a message {string} is sent to the topic {string}")
    public void a_message_is_sent_to_topic(String msg, String t)
        throws Exception {
        world.getChannel().basicPublish("topic_exchange", t, null, msg.getBytes());
    }

    @Then("a message {string} should be received by the topic {string}")
    public void a_message_should_be_received_by_topic(String msg, String t)
        throws Exception {
        RetryPolicy<Object> retryPolicy = RetryPolicy.builder()
                .withMaxRetries(10)
                .withDelay(Duration.ofSeconds(1))
                .withBackoff(100, 2000, ChronoUnit.MILLIS)
                .build();
        Failsafe.with(retryPolicy).run(() -> {
            assertTrue(world.getTopicMessages(t).contains(msg));
        });
    }
}
