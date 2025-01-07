import com.typesafe.config.Config;
import okhttp3.*;
import java.io.IOException;
import java.util.Map;

public class HttpClient {
    private final OkHttpClient httpClient;
    private final CustomWorld world;
    private final Config config;

    public HttpClient(CustomWorld world, Config config) {
        this.httpClient = new OkHttpClient();
        this.world = world;
        this.config = config;
    }

    public HttpResponse executeHttpRequest(HttpRequest request) throws IOException {
        HttpResponse res = null;
        boolean httpIgnoreErrors = this.config.getBoolean("http.ignoreErrors") ||
            world.getHttpIgnoreErrors();
        request.setBaseUrl(this.config.getString("http.baseUrl"));
        this.world.addHttpRequest(request);
        try {
            res = executeHttpRequestInternal(request);
            System.out.println(res.isSuccessful());
            if (!res.isSuccessful() && !httpIgnoreErrors) {
                throw new IOException("HTTP " + res.getStatusCode() + ": " +
                    res.getBody());
            }
        } finally { this.world.addHttpResponse(res); }
        return res;
    }

    private HttpResponse executeHttpRequestInternal(HttpRequest req)
    throws IOException {
        Request.Builder requestBuilder = new Request.Builder()
                .url(req.getUrl()).method(req.getMethod(), req.getBody() != null ?
                    RequestBody.create(req.getBody(),
                        MediaType.parse(req.getBodyType())) : null);
        for (Map.Entry<String, String> entry : req.getHeaders().entrySet()) {
            requestBuilder.addHeader(entry.getKey(), entry.getValue());
        }
        Response response = httpClient.newCall(requestBuilder.build()).execute();
        try {
            return new HttpResponse(
                    response.code(), response.headers().toMultimap(),
                    response.body() != null ? response.body().string() : null                    
            );
        } finally { response.close(); }
    }
}
