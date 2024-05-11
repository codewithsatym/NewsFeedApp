package code.app.NewsFeed.utils;

import code.app.NewsFeed.dto.RequestEverythingDTO;
import com.fasterxml.jackson.databind.JsonNode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Service
public class EverythingFeedHandler {
    @Autowired
    private HttpGateway httpGateway;

    public JsonNode getEveryThingNewsFeed(RequestEverythingDTO dto) {
        String baseUrl = dto.getBase_url();
        LocalDate fromTime = dto.getFromTime();
        String filterBy = dto.getFilterBy();
        String sortBy = dto.getSortBy();
        String key = dto.getKey();
        httpGateway.get();
        return null;
    }
}
