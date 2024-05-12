package code.app.NewsFeed.service;

import code.app.NewsFeed.dto.StandardRequestDTO;
import com.fasterxml.jackson.databind.JsonNode;

import java.util.Optional;

public interface OpenSourceService {

    JsonNode getTopHeadLines(StandardRequestDTO requestDTO, Optional<Long> keyId);

    JsonNode getEveryNews(StandardRequestDTO requestDTO, Optional<Long> keyId);
}
