package code.app.NewsFeed.utils;

import code.app.NewsFeed.dto.RequestEverythingDTO;
import code.app.NewsFeed.modal.KeysModal;
import code.app.NewsFeed.repository.KeyRepository;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

@Service
public class EverythingFeedHandler {
    @Autowired
    private HttpGateway httpGateway;
    @Autowired
    private KeyRepository keyRepository;
    @Autowired
    private ObjectMapper mapper;
    @Value("${everything.url}")
    private String everyThingURL;

    public JsonNode getEveryThingNewsFeed(RequestEverythingDTO dto, Long keyId) {
        String key = findKeyValueById(keyId);

        String url = buildURL(dto, key);
        Map<String, String> headers = new HashMap<>();
        headers.put("Content-Type", "application/x-www-form-urlencoded");
        String response= getEverythingAPIResponse(url, headers);
        try {
           return mapper.readTree(response);
        } catch (JsonProcessingException e) {
            throw new ValidationException("Error Parsing String to Json");
        }
    }

    private String getEverythingAPIResponse(String url, Map<String, String> headers) {
        return httpGateway.get(url, headers, response -> {
            int statusCode = response.getStatusLine().getStatusCode();
            return new String(response.getEntity().getContent().readAllBytes());
        });
    }

    private String buildURL(RequestEverythingDTO dto, String key) {
        UriComponentsBuilder builder = UriComponentsBuilder.fromHttpUrl(everyThingURL);

        if (dto.getFilterBy() != null) {
            builder.queryParam("q", dto.getFilterBy());
        }
        if (dto.getFromTime() != null) {
            builder.queryParam("from", dto.getFromTime());
        }
        if (dto.getSortBy() != null) {
            builder.queryParam("sortBy", dto.getSortBy());
        }
        builder.queryParam("apiKey", key);

        return builder.toUriString();
    }

    public String findKeyValueById(Long keyId) {
        try {
            Optional<KeysModal> optionalKeysModal = keyRepository.findById(keyId);
            return optionalKeysModal.get().getKey();
        } catch (Exception e) {
            throw new ValidationException("Key not present for key_id " + keyId);
        }
    }
}
