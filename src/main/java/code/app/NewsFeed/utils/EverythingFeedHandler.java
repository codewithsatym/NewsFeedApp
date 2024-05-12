package code.app.NewsFeed.utils;

import code.app.NewsFeed.dto.RequestEverythingDTO;
import code.app.NewsFeed.repository.KeyRepository;
import com.fasterxml.jackson.databind.JsonNode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Service
public class EverythingFeedHandler {
    @Autowired
    private HttpGateway httpGateway;
    @Autowired
    private KeyRepository keyRepository;

    public JsonNode getEveryThingNewsFeed(RequestEverythingDTO dto, Long keyId) {
        String key = findKeyByKeyId(keyId);
        String baseUrl = dto.getBase_url();
        LocalDate fromTime = dto.getFromTime();
        String filterBy = dto.getFilterBy();
        String sortBy = dto.getSortBy();
        httpGateway.get();
        return null;
    }

    public String findKeyByKeyId(Long keyId) {
        try {
            return keyRepository.findKeyByIf(keyId);
        } catch (Exception e) {
            throw new ValidationException("Key not present for key_id " + keyId);
        }
    }
}
