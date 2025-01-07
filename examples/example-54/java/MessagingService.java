import com.rabbitmq.client.*;

public class MessagingService {
    private Connection conn;
    private Channel channel;
    private String lastMessage = "";

    public void start() throws Exception {
        ConnectionFactory factory = new ConnectionFactory();
        factory.setHost("localhost");
        conn = factory.newConnection();
        channel = conn.createChannel();
        channel.queueDeclare("messages", false, false, true, null);
        channel.basicConsume("messages", true, (consumerTag, delivery) -> {
            lastMessage = new String(delivery.getBody(), "UTF-8");
            System.out.println("---- Received " + lastMessage);
        }, consumerTag -> { });
    }

    public void stop() throws Exception {
        if (conn != null && conn.isOpen()) { conn.close(); }
    }

    public String getLastMessage() { return lastMessage; }
}
