import com.rabbitmq.client.*;

public class CustomWorld {
    private Channel channel;
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
}
