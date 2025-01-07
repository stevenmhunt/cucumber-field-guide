import java.util.HashMap;
import java.util.Map;

public class HttpRequest {
    private String baseUrl = "";
    private final String url;
    private final String method;
    private final String body;
    private final String bodyType;
    private final Map<String, String> headers;

    public HttpRequest(String url, String method, String body) {
        this(url, method, body, null, null);
    }

    public HttpRequest(String url, String method, String body,
        Map<String, String> headers, String bodyType) {
        this.url = url;
        this.headers = headers != null ? headers : new HashMap<String,String>();
        this.method = method;
        this.body = body;
        this.bodyType = bodyType != null ? bodyType : "application/json";
    }

    public void setBaseUrl(String url) { this.baseUrl = url; }
    public String getUrl() { return baseUrl + url; }
    public String getMethod() { return method; }
    public String getBody() { return body; }
    public String getBodyType() { return bodyType; }
    public Map<String, String> getHeaders() { return headers; }
}
