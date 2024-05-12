package code.app.NewsFeed.service;

import code.app.NewsFeed.dto.StandardRequestDTO;
import code.app.NewsFeed.modal.KeysModal;
import code.app.NewsFeed.repository.KeyRepository;
import code.app.NewsFeed.utils.CommonUtils;
import code.app.NewsFeed.utils.HttpGateway;
import code.app.NewsFeed.utils.ValidationException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

@Service
public class OpenSourceServiceImpl implements OpenSourceService {
    @Autowired
    private HttpGateway httpGateway;
    @Autowired
    private KeyRepository keyRepository;
    @Autowired
    private ObjectMapper mapper;
    @Value("${everything.url}")
    private String everyThingURL;
    @Value("${everything.apiKey}")
    private String apiKey;
    @Value("${top.headings.url}")
    private String topHeadingsURL;
    @Autowired
    private CommonUtils commonUtils;

    @Override
    public JsonNode getTopHeadLines(StandardRequestDTO requestDTO, Optional<Long> keyId) {
        return callOpenSourceAPI(requestDTO, keyId, topHeadingsURL);
    }

    @Override
    public JsonNode getEveryNews(StandardRequestDTO requestDTO, Optional<Long> keyId) {
        return callOpenSourceAPI(requestDTO, keyId, everyThingURL);
    }

    private JsonNode callOpenSourceAPI(StandardRequestDTO dto, Optional<Long> keyId, String everyThingURL) {
        String key = (keyId.isPresent()) ? findKeyValueById(keyId.get()) : apiKey;
        String url = commonUtils.buildURL(dto, key, everyThingURL);
        Map<String, String> headers = new HashMap<>();
        headers.put("Content-Type", "application/x-www-form-urlencoded");
        return getAPIResponse(url, headers);
    }

    private JsonNode getAPIResponse(String url, Map<String, String> headers) {
        return httpGateway.get(url, headers, response -> {
            int statusCode = response.getStatusLine().getStatusCode();
            try {
                return mapper.readTree(new String(response.getEntity().getContent().readAllBytes()));
            } catch (IOException | UnsupportedOperationException e) {
                throw new RuntimeException(e);
            }
        });
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
