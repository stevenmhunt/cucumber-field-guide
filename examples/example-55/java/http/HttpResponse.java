import java.util.List;
import java.util.Map;

public class HttpResponse {
    private final int statusCode;
    private final String body;
    private final Map<String, List<String>> headers;

    public HttpResponse(int code, Map<String, List<String>> headers, String body) {
        this.statusCode = code;
        this.headers = headers;
        this.body = body;
    }

    public int getStatusCode() { return statusCode; }
    public boolean isSuccessful() { return statusCode >= 400; }
    public String getBody() { return body; }
    public Map<String, List<String>> getHeaders() { return headers; }
}
