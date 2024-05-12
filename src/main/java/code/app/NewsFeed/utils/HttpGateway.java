package code.app.NewsFeed.utils;

import org.apache.http.client.HttpClient;
import org.apache.http.client.ResponseHandler;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.HttpClients;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.Map;

@Service
public class HttpGateway {
    private HttpClient httpClient;
    public HttpGateway() {
        this.httpClient = HttpClients.createDefault();
    }

    public <T> T get(String url, Map<String, String> headers, ResponseHandler<T> handler) {
        HttpGet httpGet = new HttpGet(url);
        headers.forEach(httpGet::addHeader);
        try {
            return httpClient.execute(httpGet, handler);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
}
