import java.nio.channels.Channel;
import java.sql.Connection;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import com.rabbitmq.client.*;

public class CustomWorld {
    private Channel channel;
    private HashMap<String, ArrayList<String>> topicMessages = new HashMap<>();
    // ... existing code ...

    public Channel getChannel() throws Exception {
        return getChannel(true);
    }

    public Channel getChannel(boolean isLazyLoad) throws Exception {
        if (channel == null && isLazyLoad) {
            ConnectionFactory factory = new ConnectionFactory();
            factory.setHost("localhost");
            Connection connection = factory.newConnection();
            channel = connection.createChannel();
        }
        return channel;
    }

    public void addTopicMessage(String topic, String message) {
        topicMessages.computeIfAbsent(topic, k -> new ArrayList<>()).add(message);
    }

    public List<String> getTopicMessages(String topic) {
        return topicMessages.getOrDefault(topic, new ArrayList<>());
    }
}
