import com.google.inject.*;

public class UsersService {
    private final HttpService httpService;
    private final MessageBrokerService messageBrokerService;
    private final String url;

    @Inject
    public UsersService(
        HttpService http, MessageBrokerService mb, @Named("url") String url) {
        this.httpService = http;
        this.messageBrokerService = mb;
        this.url = url;
    }
}