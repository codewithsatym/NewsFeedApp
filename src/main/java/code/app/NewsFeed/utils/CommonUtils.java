package code.app.NewsFeed.utils;

import code.app.NewsFeed.dto.StandardRequestDTO;
import org.springframework.stereotype.Component;
import org.springframework.web.util.UriComponentsBuilder;

import java.time.LocalDate;

@Component
public class CommonUtils {
    public StandardRequestDTO getStandardRequestDTO(String filterBy, LocalDate fromTime, String sortBy, String country) {
        StandardRequestDTO dto = new StandardRequestDTO();
        dto.setFilterBy(filterBy);
        dto.setFromTime(fromTime);
        dto.setSortBy(sortBy);
        dto.setCountry(country);
        return dto;
    }

    public String buildURL(StandardRequestDTO dto, String key, String URL) {
        UriComponentsBuilder builder = UriComponentsBuilder.fromHttpUrl(URL);

        if (dto.getFilterBy() != null) {
            builder.queryParam("q", dto.getFilterBy());
        }
        if (dto.getFromTime() != null) {
            builder.queryParam("from", dto.getFromTime());
        }
        if (dto.getSortBy() != null) {
            builder.queryParam("sortBy", dto.getSortBy());
        }
        if (dto.getCountry() != null) {
            builder.queryParam("country", dto.getCountry());
        }
        builder.queryParam("apiKey", key);

        return builder.toUriString();
    }

}
