import io.cucumber.java.en.Given;
import java.io.IOException;
import com.typesafe.config.*;

public class HttpSteps {
    private CustomWorld world;
    private Config config;
    private HttpClient client;

    public HttpSteps(CustomWorld world) {
        String env = System.getenv("TEST_ENV");
        this.world = world;        
        this.config = ConfigFactory.load(env != null ? env : "default");
        this.client = new HttpClient(this.world, this.config);
    }

    @Before("@http-ignore-errors")
    public void before_http_ignore_errors() {
        world.setHttpIgnoreErrors(true);
    }

    @Given("an HTTP {string} call {string} is made")
    public void given_a_step_which_makes_an_http_call(String method, String url)
        throws IOException {
        this.client.executeHttpRequest(new HttpRequest(url, method, null));
    }
    @Then("the HTTP call should have returned an HTTP {int}")
    public void then_the_last_http_call_returned(int status) {
        int actual = world.getHttpResponses().get(0).getStatusCode();
        Assertions.assertEquals(status, actual);
    }
}
