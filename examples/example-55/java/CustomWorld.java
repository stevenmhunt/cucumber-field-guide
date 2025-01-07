import java.util.ArrayList;
import java.util.List;

public class CustomWorld {
    private boolean httpIgnoreErrors = false;
    private List<HttpRequest> httpRequests = new ArrayList<HttpRequest>();
    private List<HttpResponse> httpResponses = new ArrayList<HttpResponse>();

    public List<HttpRequest> getHttpRequests() {
        return httpRequests;
    }

    public List<HttpResponse> getHttpResponses() {
        return httpResponses;
    }

    public void addHttpRequest(HttpRequest req) {
        httpRequests.add(0, req);
    }

    public void addHttpResponse(HttpResponse res) {
        httpResponses.add(0, res);
    }

    public boolean getHttpIgnoreErrors() {
        return httpIgnoreErrors;
    }

    public void setHttpIgnoreErrors(boolean value) {
        httpIgnoreErrors = value;
    }
}
